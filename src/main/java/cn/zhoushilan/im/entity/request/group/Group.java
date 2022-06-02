package cn.zhoushilan.im.entity.request.group;

import cn.zhoushilan.im.entity.common.MapKV;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Group {

    /**
     * 群主 id，自动添加到群成员中。如果不填，群没有群主。
     */
    @JsonProperty("Owner_Account")
    @ApiModelProperty("群主")
    private String ownerAccount;

    /**
     * 包括 Public（公开群），Private（私密群），
     * ChatRoom（聊天室），AVChatRoom（互动直播聊天室），
     * BChatRoom（在线成员广播大群）
     */
    @JsonProperty("Type")
    @ApiModelProperty("群类型")
    private String type;

    /**
     * 群组 ID 更加简单
     */
    @JsonProperty("GroupId")
    @ApiModelProperty("群ID")
    private String groupId;

    /**
     * 群名称，最长30字节，使用 UTF-8 编码，1个汉字占3个字节
     */
    @JsonProperty("Name")
    @ApiModelProperty("群名称")
    private String name;

    /**
     * 群简介，最长240字节，使用 UTF-8 编码，1个汉字占3个字节
     */
    @JsonProperty("Introduction")
    @ApiModelProperty("群简介")
    private String introduction;

    /**
     * 群公告，最长300字节，使用 UTF-8 编码，1个汉字占3个字节
     */
    @JsonProperty("Notification")
    @ApiModelProperty("群公告")
    private String notification;

    /**
     * 群头像
     */
    @JsonProperty("FaceUrl")
    @ApiModelProperty("群头像")
    private String faceUrl;

    /**
     * 最大群成员数量，缺省时的默认值：私有群是 200，公开群是 2000，
     * 聊天室是 10000，互动直播聊天室和在线成员广播大群无限制。
     */
    @JsonProperty("MaxMemberCount")
    @ApiModelProperty("群人数")
    private Integer maxMemberCount;

    /**
     * 申请加群处理方式。
     * 包含 FreeAccess（自由加入），
     * NeedPermission（需要验证），
     * DisableApply（禁止加群），
     * 不填默认为 NeedPermission（需要验证）。
     */
    @JsonProperty("ApplyJoinOption")
    @ApiModelProperty("加群方式")
    private String applyJoinOption;

    /**
     * On开启 Off关闭
     */
    @JsonProperty("ShutUpAllMember")
    @ApiModelProperty("群内成员禁言")
    private String shutUpAllMember;

    /**
     * 群组维度的自定义字段
     */
    @JsonProperty("AppDefinedData")
    @ApiModelProperty("自定义维度")
    private List<MapKV> AppDefinedData;

    /**
     * 初始群成员列表
     */
    @JsonProperty("MemberList")
    private List<AppMember> memberList;

}
