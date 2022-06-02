package cn.zhoushilan.im.entity.request.push;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class MemberTags {

    @JsonProperty("UserTags")
    @ApiModelProperty("用户标签列表")
    private List<SetMemberTag> userTags;

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
class SetMemberTag {
    /**
     * 用户账号
     */
    @JsonProperty("To_Account")
    @ApiModelProperty("用户账号")
    private String toAccount;

    /**
     * 用户属性
     */
    @JsonProperty("Tags")
    @ApiModelProperty("用户标签")
    private List<String> tags;

}
