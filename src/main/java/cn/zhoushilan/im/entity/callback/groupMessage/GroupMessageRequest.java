package cn.zhoushilan.im.entity.callback.groupMessage;

import cn.zhoushilan.im.entity.request.message.MsgBody;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroupMessageRequest {

    @ApiModelProperty("回调命令")
    @JsonProperty("CallbackCommand")
    private String callbackCommand;

    @ApiModelProperty("群组 ID")
    @JsonProperty("GroupId")
    private String groupId;

    @ApiModelProperty("群组类型")
    @JsonProperty("Type")
    private String type;

    @ApiModelProperty("消息顺序")
    @JsonProperty("MsgSeq")
    private Long msgSeq;

    @ApiModelProperty("消息时间")
    @JsonProperty("MsgTime")
    private Long msgTime;

    @ApiModelProperty("发送者")
    @JsonProperty("From_Account")
    private String fromAccount;

    @ApiModelProperty("请求的发起者")
    @JsonProperty("Operator_Account")
    private String operatorAccount;

    @ApiModelProperty("随机数")
    @JsonProperty("Random")
    private Long random;

    @ApiModelProperty("消息内容")
    @JsonProperty("MsgBody")
    private List<MsgBody> msgBody;
}
