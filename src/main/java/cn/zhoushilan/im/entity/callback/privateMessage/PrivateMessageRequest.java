package cn.zhoushilan.im.entity.callback.privateMessage;

import cn.zhoushilan.im.entity.request.message.MsgBody;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PrivateMessageRequest {

    @ApiModelProperty("发信人")
    @JsonProperty("From_Account")
    private Long fromAccount;

    @ApiModelProperty("收信人")
    @JsonProperty("To_Account")
    private Long toAccount;

    @ApiModelProperty("消息序列号")
    @JsonProperty("MsgSeq")
    private Long msgSeq;

    @ApiModelProperty("消息随机数")
    @JsonProperty("MsgRandom")
    private Long msgRandom;

    @ApiModelProperty("消息时间戳")
    @JsonProperty("MsgTime")
    private Long msgTime;

    @ApiModelProperty("消息标识")
    @JsonProperty("MsgKey")
    private String msgKey;

    @ApiModelProperty("消息下发结果")
    @JsonProperty("SendMsgResult")
    private Integer sendMsgResult;

    @ApiModelProperty("消息下发错误信息")
    @JsonProperty("ErrorInfo")
    private String errorInfo;

    @ApiModelProperty("消息未读数量")
    @JsonProperty("UnreadMsgNum")
    private Integer unreadMsgNum;

    @ApiModelProperty("消息内容")
    @JsonProperty("MsgBody")
    private List<MsgBody> msgBody;
}
