package cn.zhoushilan.im.entity.response.friend;

import cn.zhoushilan.im.entity.IMActionResponse;
import cn.zhoushilan.im.entity.request.message.MsgBody;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@EqualsAndHashCode(callSuper = true)
public class QueryPrivateMsgBody extends IMActionResponse {

    @ApiModelProperty("发信人")
    @JsonProperty("From_Account")
    private Long fromAccount;

    @ApiModelProperty("收信人")
    @JsonProperty("To_Account")
    private Long toAccount;

    @ApiModelProperty("消息序列号")
    @JsonProperty("MsgSeq")
    private Integer msgSeq;

    @ApiModelProperty("消息随机数")
    @JsonProperty("MsgRandom")
    private Long msgRandom;

    @ApiModelProperty("消息时间戳")
    @JsonProperty("MsgTimeStamp")
    private Integer msgTime;

    @ApiModelProperty("该条消息的属性，0表示正常消息，8表示被撤回的消息")
    @JsonProperty("MsgFlagBits")
    private Boolean msgFlagBits;

    private Integer sendMsgResult = 0;

    @ApiModelProperty("消息标识")
    @JsonProperty("MsgKey")
    private String msgKey;

    @JsonProperty("MsgBody")
    @ApiModelProperty("消息内容")
    private List<MsgBody> msgBody;

}
