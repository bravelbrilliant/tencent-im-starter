package cn.zhoushilan.im.entity.request.friend;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class FriendGroup {
    /**
     * @program: pms
     * @description:
     * @author: Lee Ann
     * @create: 2021-02-01 11:42
     **/
    @ApiModelProperty("添加帐号")
    @JsonProperty("From_Account")
    private String fromAccount;

    @ApiModelProperty("群组名列表")
    @JsonProperty("GroupName")
    private List<String> groupName;

    @ApiModelProperty("添加帐号")
    @JsonProperty("To_Account")
    private List<String> toAccount;

}
