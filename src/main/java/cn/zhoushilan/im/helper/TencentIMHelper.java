package cn.zhoushilan.im.helper;


import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import cn.zhoushilan.im.annotation.ChildUri;
import cn.zhoushilan.im.config.ApiSysConfig;
import cn.zhoushilan.im.entity.IMActionResponse;
import cn.zhoushilan.im.entity.request.friend.*;
import cn.zhoushilan.im.entity.request.group.*;
import cn.zhoushilan.im.entity.request.message.*;
import cn.zhoushilan.im.entity.request.push.MemberTags;
import cn.zhoushilan.im.entity.request.push.RemoveMemberAttrs;
import cn.zhoushilan.im.entity.request.push.SetMemberAttrs;
import cn.zhoushilan.im.entity.request.user.CheckItems;
import cn.zhoushilan.im.entity.request.user.DeleteItems;
import cn.zhoushilan.im.entity.request.user.IMUser;
import cn.zhoushilan.im.entity.request.user.PortraitSetItems;
import cn.zhoushilan.im.entity.response.friend.QueryPrivateMsg;
import cn.zhoushilan.im.util.HttpClientUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import com.tencentyun.TLSSigAPIv2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;


@Slf4j
@Component
public class TencentIMHelper {

    @Autowired
    private ApiSysConfig apiSysConfig;

    private ConcurrentHashMap<String, String> usersigHashMap = new ConcurrentHashMap<>();

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private StringRedisTemplate redisTemplate;

    private String REDIS_CACHE_PREFIX = "IM_USER_";

    /**
     * 封装请求参数
     */
    private Joiner.MapJoiner joiner = Joiner.on("&").withKeyValueSeparator("=");


    /**
     * http 请求service
     *
     * @param url
     * @param params
     * @return
     */
    private String requestInvoke(String url, Object params) {
        String resultJson = null;
        try {
            String paramsJson = objectMapper.writeValueAsString(params);
            log.info("Request url and params {} | {}", url, paramsJson);
            resultJson = HttpClientUtil.sendJsonData(url, paramsJson);
            log.info("request result is {}", resultJson);
        } catch (Exception e) {
            log.error("Request invoke failed", e);
        }
        return resultJson;
    }

    private JSON request(String url, Object params) {
        String json = requestInvoke(url, params);
        return JSONUtil.parse(json);
    }

    /**
     * 生成usersig,for internal use only
     *
     * @param userId
     * @return
     */
    public String _genUsersig(String userId, Long userSigExpiration) {
        ValueOperations opsForValue = redisTemplate.opsForValue();
        String usersig = (String) opsForValue.get(REDIS_CACHE_PREFIX + userId);
        if (!StringUtils.isEmpty(usersig)) {
            return usersig;
        }
        usersig = genUsersig(userId, userSigExpiration);
        opsForValue.set(REDIS_CACHE_PREFIX + userId, usersig, userSigExpiration, TimeUnit.SECONDS);
        usersigHashMap.put(userId, usersig);
        return usersig;
    }

    /**
     * 生成usersig
     *
     * @param userId
     * @param expiration
     * @return
     */
    public String genUsersig(String userId, Long expiration) {
        TLSSigAPIv2 api = new TLSSigAPIv2(apiSysConfig.getSdkappid(), apiSysConfig.getPriKey());
        return api.genUserSig(userId, expiration);
    }


    /**
     * 返回默认的参数
     *
     * @return
     */
    private Map<String, String> getDefaultParams() {
        Map<String, String> pathParams = Maps.newLinkedHashMap();

        pathParams.put("identifier", apiSysConfig.getIdentifier());
        pathParams.put("sdkappid", apiSysConfig.getSdkappid().toString());
        pathParams.put("random", UUID.randomUUID().toString().replace("-", "").toLowerCase());
        pathParams.put("contenttype", "json");
        Long oneHundredYear = 3600 * 24L;
        pathParams.put("usersig", _genUsersig(apiSysConfig.getIdentifier(), oneHundredYear));

        return pathParams;
    }

    /**
     * 获取调用方法注解里的子路径
     *
     * @return
     */
    private String getUrl(Class... params) {
        try {
            String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
            Method method = null;
            if (params == null) {
                method = this.getClass().getDeclaredMethod(methodName);
            } else {
                method = this.getClass().getDeclaredMethod(methodName, params);
            }
            String childUri = method.getAnnotation(ChildUri.class).value();
            String uri = apiSysConfig.getBaseUri() + childUri;
            return uri + "?" + joiner.join(getDefaultParams());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException("Get Child uri failed", e);
        }
    }


    /**
     * 导入账号
     *
     * @param user
     */
    @ChildUri("im_open_login_svc/account_import")
    public JSON accountImport(IMUser user) {
        String url = this.getUrl(IMUser.class);
        return request(url, user);
    }

    /**
     * 查询账号
     *
     * @param userItems
     */
    @ChildUri("im_open_login_svc/account_check")
    public JSON accountCheck(CheckItems userItems) {
        String url = this.getUrl(CheckItems.class);
        return request(url, userItems);
    }


    /**
     * 查询账号在线状态
     *
     * @param checkUser
     */
    @ChildUri("openim/query_online_status")
    public JSON queryOnlineStatus(CheckUser checkUser) {
        String url = this.getUrl(CheckUser.class);
        return request(url, checkUser);
    }

    /**
     * 失效帐号登录状态
     *
     * @param userId
     */
    @ChildUri("im_open_login_svc/kick")
    public Boolean kick(Long userId) throws Exception {
        IMUser imUser = new IMUser();
        imUser.setIdentifier(String.valueOf(userId));
        String url = this.getUrl(Long.class);
        JSON json = request(url, imUser);
        if (json != null) {
            IMActionResponse response = objectMapper.readValue(json.toString(), IMActionResponse.class);
            if (response.isSuccess()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 设置资料
     *
     * @param portraitSetItems
     */
    @ChildUri("profile/portrait_set")
    public Boolean portraitSet(PortraitSetItems portraitSetItems) throws Exception {
        String url = this.getUrl(PortraitSetItems.class);
        JSON json = request(url, portraitSetItems);
        if (json != null) {
            IMActionResponse response = objectMapper.readValue(json.toString(), IMActionResponse.class);
            if (response.isSuccess()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 删除账号
     *
     * @param deleteItems
     */
    @ChildUri("im_open_login_svc/account_delete")
    public JSON accountDelete(DeleteItems deleteItems) {
        String url = this.getUrl(DeleteItems.class);
        return request(url, deleteItems);
    }

    /**
     * 单发单聊消息
     */
    @ChildUri("openim/sendmsg")
    public JSON sendMsg(Message message) {
        String url = this.getUrl(Message.class);
        return request(url, message);
    }

    /**
     * 查询单聊消息
     */
    @ChildUri("openim/admin_getroammsg")
    public QueryPrivateMsg getRoamMsg(MessageRequest messageRequest) throws Exception {
        String url = this.getUrl(MessageRequest.class);
        JSON json = request(url, messageRequest);
        return objectMapper.readValue(json.toString(), QueryPrivateMsg.class);
    }

    /**
     * 撤回单聊消息
     */
    @ChildUri("openim/admin_msgwithdraw")
    public JSON withdrawMsg(MessageRequest messageRequest) {
        String url = this.getUrl(MessageRequest.class);
        return request(url, messageRequest);
    }

    /**
     * 添加好友
     */
    @ChildUri("sns/friend_add")
    public JSON addFriend(Friend friend) {
        String url = this.getUrl(Friend.class);
        return request(url, friend);
    }

    /**
     * 更新好友
     */
    @ChildUri("sns/friend_update")
    public JSON updateFriend(Friend friend) {
        String url = this.getUrl(Friend.class);
        return request(url, friend);
    }

    /**
     * 拉取好友
     */
    @ChildUri("sns/friend_get")
    public JSON getFriend(QueryFriend queryFriend) {
        String url = this.getUrl(QueryFriend.class);
        return request(url, queryFriend);
    }

    /**
     * 删除好友
     */
    @ChildUri("sns/friend_delete")
    public JSON deleteFriend(DeleteFriend deleteFriendItem) {
        String url = this.getUrl(DeleteFriend.class);
        return request(url, deleteFriendItem);
    }

    /**
     * 删除所有好友
     */
    @ChildUri("sns/friend_delete_all")
    public JSON deleteAllFriend(DeleteFriend deleteFriendItem) {
        String url = this.getUrl(DeleteFriend.class);
        return request(url, deleteFriendItem);
    }

    /**
     * 校验好友
     */
    @ChildUri("sns/friend_checks")
    public JSON checkFriends(CheckFriend checkFriend) {
        String url = this.getUrl(CheckFriend.class);
        return request(url, checkFriend);
    }

    /**
     * 添加黑名单
     */
    @ChildUri("sns/black_list_add")
    public JSON blackFriend(BlackListFriend blackListFriendItem) {
        String url = this.getUrl(BlackListFriend.class);
        return request(url, blackListFriendItem);
    }

    /**
     * 删除黑名单
     */
    @ChildUri("sns/friend_delete_all")
    public JSON deleteBlackList(BlackListFriend blackListFriendItem) {
        String url = this.getUrl(BlackListFriend.class);
        return request(url, blackListFriendItem);
    }

    /**
     * 删除黑名单
     */
    @ChildUri("sns/black_list_get")
    public JSON queryBlackList(QueryBlackList queryBlackListItem) {
        String url = this.getUrl(QueryBlackList.class);
        return request(url, queryBlackListItem);
    }

    /**
     * 添加分组
     */
    @ChildUri("sns/group_add")
    public JSON addFriendGroup(FriendGroup friendGroup) {
        String url = this.getUrl(FriendGroup.class);
        return request(url, friendGroup);
    }

    /**
     * 删除分组
     */
    @ChildUri("sns/group_delete")
    public JSON deleteFriendGroup(FriendGroup friendGroup) {
        String url = this.getUrl(FriendGroup.class);
        return request(url, friendGroup);
    }

    /**
     * 获取APP中的所有群组
     */
    @ChildUri("group_open_http_svc/get_appid_group_list")
    public JSON getGroupList(QueryGroup queryGroup) {
        String url = this.getUrl(QueryGroup.class);
        return request(url, queryGroup);
    }

    /**
     * 创建群组 公开群人数：2000
     */
    @ChildUri("group_open_http_svc/create_group")
    public JSON createGroup(Group group) {
        String url = this.getUrl(Group.class);
        return request(url, group);
    }

    /**
     * 获取群详细资料
     *
     * @param queryGroupDetailItem
     * @return
     */
    @ChildUri("group_open_http_svc/get_group_info")
    public JSON getGroupInfo(QueryGroupDetail queryGroupDetailItem) {
        String url = this.getUrl(QueryGroupDetail.class);
        return request(url, queryGroupDetailItem);
    }

    /**
     * 获取群成员详细资料
     *
     * @param queryGroupMemberDetailItem
     * @return
     */
    @ChildUri("group_open_http_svc/get_group_member_info")
    public JSON getGroupMemberInfo(QueryGroupMemberDetail queryGroupMemberDetailItem) {
        String url = this.getUrl(QueryGroupMemberDetail.class);
        return request(url, queryGroupMemberDetailItem);
    }

    /**
     * 修改群基础资料
     *
     * @param group
     * @return
     */
    @ChildUri("group_open_http_svc/modify_group_base_info")
    public JSON modifyGroupBaseInfo(Group group) {
        String url = this.getUrl(Group.class);
        return request(url, group);
    }

    /**
     * 添加群组成员
     *
     * @param addAppMemberItem
     * @return
     */
    @ChildUri("group_open_http_svc/add_group_member")
    public JSON addGroupMember(AddAppMember addAppMemberItem) {
        String url = this.getUrl(AddAppMember.class);
        return request(url, addAppMemberItem);
    }

    /**
     * 删除群组成员
     *
     * @param deleteAppMemberItem
     * @return
     */
    @ChildUri("group_open_http_svc/delete_group_member")
    public JSON deleteGroupMember(DeleteAppMember deleteAppMemberItem) {
        String url = this.getUrl(DeleteAppMember.class);
        return request(url, deleteAppMemberItem);
    }

    /**
     * 修改群组成员
     *
     * @param updateAppMemberItem
     * @return
     */
    @ChildUri("group_open_http_svc/modify_group_member_info")
    public JSON modifyGroupMember(UpdateAppMember updateAppMemberItem) {
        String url = this.getUrl(UpdateAppMember.class);
        return request(url, updateAppMemberItem);
    }

    /**
     * 解散群组
     *
     * @param destroyGroupItem
     * @return
     */
    @ChildUri("group_open_http_svc/destroy_group")
    public JSON destroyGroup(DestroyGroup destroyGroupItem) {
        String url = this.getUrl(UpdateAppMember.class);
        return request(url, destroyGroupItem);
    }

    /**
     * 查询用户所在的组
     *
     * @param queryGroupsOfMemberItem
     * @return
     */
    @ChildUri("group_open_http_svc/get_joined_group_list")
    public JSON getJoinedGroupList(QueryGroupsOfMember queryGroupsOfMemberItem) {
        String url = this.getUrl(QueryGroupsOfMember.class);
        return request(url, queryGroupsOfMemberItem);
    }

    /**
     * 批量禁言和取消禁言
     *
     * @param destroyGroupItem
     * @return
     */
    @ChildUri("group_open_http_svc/forbid_send_msg")
    public JSON forbidSendMsg(DestroyGroup destroyGroupItem) {
        String url = this.getUrl(UpdateAppMember.class);
        return request(url, destroyGroupItem);
    }

    /**
     * 群组中发普通消息
     *
     * @param groupMessage
     * @return
     */
    @ChildUri("group_open_http_svc/send_group_msg")
    public JSON sendGroupMsg(GroupMessage groupMessage) {
        String url = this.getUrl(GroupMessage.class);
        return request(url, groupMessage);
    }

    /**
     * 群组中发系统消息
     *
     * @param groupSystemMessage
     * @return
     */
    @ChildUri("group_open_http_svc/send_group_system_notification")
    public JSON sendGroupSystemNotification(GroupSystemMessage groupSystemMessage) {
        String url = this.getUrl(GroupSystemMessage.class);
        return request(url, groupSystemMessage);
    }

    /**
     * 导入群基础资料
     *
     * @param group
     * @return
     */
    @ChildUri("group_open_http_svc/import_group")
    public JSON importGroup(Group group) {
        String url = this.getUrl(Group.class);
        return request(url, group);
    }

    /**
     * 导入群消息
     *
     * @param importGroupMessage
     * @return
     */
    @ChildUri("group_open_http_svc/import_group_msg")
    public JSON importGroupMsg(ImportGroupMessage importGroupMessage) {
        String url = this.getUrl(ImportGroupMessage.class);
        return request(url, importGroupMessage);
    }


    /**
     * 导入群成员
     *
     * @param importAppMember
     * @return
     */
    @ChildUri("group_open_http_svc/import_group_member")
    public JSON importGroupMember(ImportAppMember importAppMember) {
        String url = this.getUrl(ImportAppMember.class);
        return request(url, importAppMember);
    }


    /**
     * 转让群主
     *
     * @param newGroupOwner
     * @return
     */
    @ChildUri("group_open_http_svc/change_group_owner")
    public JSON changeGroupOwner(NewGroupOwner newGroupOwner) {
        String url = this.getUrl(NewGroupOwner.class);
        return request(url, newGroupOwner);
    }

    /**
     * 撤回最近1000条消息中指定用户发送的消息
     *
     * @param cancelMemberMessage
     * @return
     */
    @ChildUri("group_open_http_svc/delete_group_msg_by_sender")
    public JSON deleteGroupMsgBySender(CancelMemberMessage cancelMemberMessage) {
        String url = this.getUrl(CancelMemberMessage.class);
        return request(url, cancelMemberMessage);
    }


    /**
     * 获取群消息列表
     *
     * @param queryGroupMessage
     * @return
     */
    @ChildUri("group_open_http_svc/group_msg_get_simple")
    public JSON getGroupMsgList(QueryGroupMessage queryGroupMessage) {
        String url = this.getUrl(QueryGroupMessage.class);
        return request(url, queryGroupMessage);
    }


    /**
     * 设置应用属性
     *
     * @param attrMap
     * @return
     */
    @ChildUri("all_member_push/im_set_attr_name")
    public JSON setAttrName(Map<String, String> attrMap) {
        String url = this.getUrl(Map.class);
        return request(url, attrMap);
    }


    /**
     * 设置用户属性
     *
     * @param setMemberAttrs
     * @return
     */
    @ChildUri("all_member_push/im_set_attr")
    public JSON setMemberAttr(SetMemberAttrs setMemberAttrs) {
        String url = this.getUrl(SetMemberAttrs.class);
        return request(url, setMemberAttrs);
    }


    /**
     * 删除用户属性
     *
     * @param removeMemberAttrs
     * @return
     */
    @ChildUri("all_member_push/im_remove_attr")
    public JSON removeMemberAttr(RemoveMemberAttrs removeMemberAttrs) {
        String url = this.getUrl(RemoveMemberAttrs.class);
        return request(url, removeMemberAttrs);
    }


    /**
     * 添加用户标签
     *
     * @param memberTags
     * @return
     */
    @ChildUri("all_member_push/im_add_tag")
    public JSON addMemberTa(MemberTags memberTags) {
        String url = this.getUrl(MemberTags.class);
        return request(url, memberTags);
    }

    /**
     * 删除用户标签
     *
     * @param memberTags
     * @return
     */
    @ChildUri("all_member_push/im_remove_tag")
    public JSON removeMemberTag(MemberTags memberTags) {
        String url = this.getUrl(MemberTags.class);
        return request(url, memberTags);
    }


    /**
     * 消息推送
     *
     * @param pushMessage
     * @return
     */
    @ChildUri("all_member_push/im_push")
    public JSON pushMessage(PushMessage pushMessage) {
        String url = this.getUrl(PushMessage.class);
        return request(url, pushMessage);
    }

}
