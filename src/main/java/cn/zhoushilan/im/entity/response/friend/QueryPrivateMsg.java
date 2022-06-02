package cn.zhoushilan.im.entity.response.friend;

import cn.zhoushilan.im.entity.IMActionResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@EqualsAndHashCode(callSuper = true)
public class QueryPrivateMsg extends IMActionResponse {

    @ApiModelProperty("本次拉取到的消息里的最后一条消息的时间")
    @JsonProperty("LastMsgTime")
    private Long lastMsgTime;

    @ApiModelProperty("本次拉取到的消息里的最后一条消息的标识")
    @JsonProperty("LastMsgKey")
    private String lastMsgKey;

    @ApiModelProperty("是否全部拉取，0表示未全部拉取，需要续拉，1表示已全部拉取")
    @JsonProperty("Complete")
    private Integer complete;

    @ApiModelProperty("本次拉取到的消息条数")
    @JsonProperty("MsgCnt")
    private Integer msgCnt;

    @JsonProperty("MsgList")
    @ApiModelProperty("消息列表")
    private List<QueryPrivateMsgBody> msgList;

}
