package cn.zhoushilan.im.entity.request.push;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class RemoveMemberAttrs {

    @JsonProperty("UserAttrs")
    @ApiModelProperty("用户属性列表")
    private List<RemoveMemberAttr> userAttrs;

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
class RemoveMemberAttr {
    /**
     * 用户账号
     */
    @JsonProperty("To_Account")
    @ApiModelProperty("用户账号")
    private String toAccount;

    /**
     * 用户属性
     */
    @JsonProperty("Attrs")
    @ApiModelProperty("用户属性")
    private List<String> delAttrs;
}
