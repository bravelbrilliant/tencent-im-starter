package cn.zhoushilan.im.entity.request.group;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ForbidSendMsg {

    @JsonProperty("GroupId")
    @ApiModelProperty("群组id")
    private String groupId;

    /**
     * 成员账号
     */
    @JsonProperty("Member_Account")
    @ApiModelProperty("成员账号列表")
    private List<String> memberAccount;

    /**
     * 禁言时间, 0代表不禁言
     */
    @JsonProperty("ShutUpTime")
    @ApiModelProperty("禁言时间")
    private Integer shutUpTime;

}
