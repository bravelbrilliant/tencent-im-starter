package cn.zhoushilan.im.entity.callback.friend;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude( JsonInclude.Include.NON_NULL)
public class AddFriendRequest {

    /**
     * 回调命令
     */
    @JsonProperty("CallbackCommand")
    @ApiModelProperty("回调命令")
    private String callbackCommand;

    /**
     * 成功添加的好友列表
     */
    @JsonProperty("PairList")
    @ApiModelProperty("成功添加的好友列表")
    private List<AddFriendCallback> addFriendList;

    /**
     * 触发回调的命令字：
     * 加好友请求，合理的取值如下：friend_add、FriendAdd
     * 加好友回应，合理的取值如下：friend_response、FriendResponse
     */
    @JsonProperty("ClientCmd")
    @ApiModelProperty("触发回调的命令字")
    private String clientCmd;

    /**
     * 如果当前请求是后台触发的加好友请求，则该字段被赋值为管理员帐号；否则为空
     */
    @JsonProperty("Admin_Account")
    @ApiModelProperty("发起添加好友申请的管理员账号")
    private String adminAccount;

    /**
     * 管理员强制加好友标记：1 表示强制加好友；0 表示常规加好友方式
     */
    @JsonProperty("ForceFlag")
    @ApiModelProperty("是否强制添加好友标记")
    private String forceFlag;
}