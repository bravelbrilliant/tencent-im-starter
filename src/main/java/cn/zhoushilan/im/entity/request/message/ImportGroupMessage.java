package cn.zhoushilan.im.entity.request.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ImportGroupMessage {

    @JsonProperty("GroupId")
    @ApiModelProperty("群ID")
    private String groupId;

    @JsonProperty("MsgList")
    @ApiModelProperty("群消息列表")
    private List<ImportGroupMessage> msgList;

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
class ImportGroupMessageItem{
    /**
     * 消息发送方帐号。（用于指定发送消息方帐号）
     */
    @JsonProperty("From_Account")
    @ApiModelProperty("消息发送账号")
    private String fromAccount;


    /**
     * 消息随机数,由随机函数产生。（用作消息去重）
     */
    @JsonProperty("Random")
    @ApiModelProperty("随机数")
    private Long random;

    /**s
     * 消息随机数,由随机函数产生。（用作消息去重）
     */
    @JsonProperty("SendTime")
    @ApiModelProperty("发送时间")
    private Long sendTime;

    /**
     * 消息信息
     */
    @JsonProperty("MsgBody")
    @ApiModelProperty("消息发送账号")
    private List<MsgBody> msgBody;
}