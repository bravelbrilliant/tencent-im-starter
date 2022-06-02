package cn.zhoushilan.im.entity.request.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class AtMemberItem {

    /**
     * 为1表示@all,为0表示@某个群成员
     */
    @JsonProperty("Member_Account")
    @ApiModelProperty("@某个成员或者全部")
    private String GroupAtAllFlag;

    /**
     * 群成员账号
     */
    @JsonProperty("Member_Account")
    @ApiModelProperty("成员账号列表")
    private String GroupAt_Account;
}
