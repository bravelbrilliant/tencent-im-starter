package cn.zhoushilan.im.entity.request.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CancelMemberMessage {

    @JsonProperty("GroupId")
    @ApiModelProperty("群ID")
    private String groupId;

    /**
     * key is MsgSeq, the message sequence list
     */
    @JsonProperty("Sender_Account")
    @ApiModelProperty("发送消息的人")
    private String Sender_Account;

}

