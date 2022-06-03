package cn.zhoushilan.im.entity.request.friend;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class BlackListFriend {

    @ApiModelProperty("添加帐号")
    @JsonProperty("From_Account")
    private String fromAccount;

    @ApiModelProperty("被添加账号")
    @JsonProperty("To_Account")
    private List<String> toAccount;

}
