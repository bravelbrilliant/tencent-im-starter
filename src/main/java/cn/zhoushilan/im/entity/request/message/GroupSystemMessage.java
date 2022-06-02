package cn.zhoushilan.im.entity.request.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class GroupSystemMessage {

    @JsonProperty("GroupId")
    @ApiModelProperty("群Id")
    private String groupId;

    /**
     * 消息发送方帐号。（用于指定发送消息方帐号）
     */
    @JsonProperty("ToMembers_Account")
    @ApiModelProperty("接受成员列表")
    private String toMembersAccount;

    /**
     * 消息接收方帐号。
     */
    @JsonProperty("Content")
    @ApiModelProperty("系统消息")
    private String content;


}
