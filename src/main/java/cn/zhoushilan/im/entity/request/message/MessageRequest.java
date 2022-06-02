package cn.zhoushilan.im.entity.request.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MessageRequest {
/**
 * @program: pms
 *
 * @description:
 *
 * @author: Lee Ann
 *
 * @create: 2021-01-28 15:36
 **/


    @ApiModelProperty("消息发送方帐号")
    @JsonProperty("From_Account")
    private String fromAccount;

    @ApiModelProperty("消息接收方帐号")
    @JsonProperty("To_Account")
    private String toAccount;

    @ApiModelProperty("请求消息数")
    @JsonProperty("MaxCnt")
    private Integer maxCnt;

    @ApiModelProperty("消息开始时间")
    @JsonProperty("MinTime")
    private Long minTime;

    @ApiModelProperty("消息结束时间")
    @JsonProperty("MaxTime")
    private Long maxTime;

    @ApiModelProperty("最后一条消息的MsgKey")
    @JsonProperty("LastMsgKey")
    private String lastMsgKey;

    @ApiModelProperty("消息的msgKey")
    @JsonProperty("MsgKey")
    private String msgKey;

}
