package cn.zhoushilan.im.entity.request.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class GroupMessage {

    @JsonProperty("GroupId")
    @ApiModelProperty("群ID")
    private String groupId;

    /**
     * 消息发送方帐号。（用于指定发送消息方帐号）
     */
    @JsonProperty("From_Account")
    @ApiModelProperty("消息发送账号")
    private String fromAccount;

    /**
     * 消息接收方帐号。
     */
    @JsonProperty("MsgPriority")
    @ApiModelProperty("消息优先级")
    private String MsgPriority;

    /**
     * 消息随机数,由随机函数产生。（用作消息去重）
     */
    @JsonProperty("MsgRandom")
    private Integer msgRandom;

    @JsonProperty("ForbidCallbackControl")
    @ApiModelProperty("是否允许回调")
    private List<String> forbidCallbackControl;

    /**
     * 消息信息
     */
    @JsonProperty("MsgBody")
    private List<MsgBody> msgBody;

    /**
     * 离线信息设置
     */
    @JsonProperty("OfflinePushInfo")
    private OfflinePushInfo offlinePushInfo;

    @JsonProperty("GroupAtInfo")
    @ApiModelProperty("@群里的用户数")
    private List<AtMemberItem> groupAtInfo;

}
