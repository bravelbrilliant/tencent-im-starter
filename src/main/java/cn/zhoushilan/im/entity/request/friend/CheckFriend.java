package cn.zhoushilan.im.entity.request.friend;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CheckFriend {
    /**
     * @program: pms
     * @description:
     * @author: LXC
     * @create: 2021-03-08 19:42
     **/
    @ApiModelProperty("查询帐号")
    @JsonProperty("From_Account")
    private String fromAccount;

    @ApiModelProperty("校验的好友的UserID列表")
    @JsonProperty("To_Account")
    private List<String> toAccount;

    @ApiModelProperty("校验模式")
    @JsonProperty("CheckType")
    private String checkType;


}
