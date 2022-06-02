package cn.zhoushilan.im.entity.request.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CancelGroupMessage {

    @JsonProperty("GroupId")
    @ApiModelProperty("群ID")
    private String groupId;

    /**
     * key is MsgSeq, the message sequence list
     */
    @JsonProperty("MsgSeqList")
    @ApiModelProperty("消息发送账号")
    private List<Map> msgSeqList;

}

