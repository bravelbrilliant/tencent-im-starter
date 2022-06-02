package cn.zhoushilan.im.entity.callback.friend;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class AddFriendCallback {

    @ApiModelProperty("好友添加方")
    @JsonProperty("From_Account")
    private String fromAccount;

    @ApiModelProperty("被添加好友方")
    @JsonProperty("To_Account")
    private String toAccount;

    @ApiModelProperty("发起加好友请求的用户的 UserID")
    @JsonProperty("Initiator_Account")
    private String initiatorAccount;

}
