package cn.zhoushilan.im.entity.callback.friend;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class DeleteFriendCallback {

    @ApiModelProperty("删除人帐号")
    @JsonProperty("From_Account")
    private String fromAccount;

    @ApiModelProperty("被删除好友账号")
    @JsonProperty("To_Account")
    private String toAccount;

}
