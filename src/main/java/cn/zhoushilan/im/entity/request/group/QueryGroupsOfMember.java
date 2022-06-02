package cn.zhoushilan.im.entity.request.group;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class QueryGroupsOfMember {

    /**
     * 本次获取的群组 ID 数量的上限，不得超过 10000。如果不填，默认为最大值 10000。
     */
    @JsonProperty("Member_Account")
    @ApiModelProperty("用户名")
    private String memberAccount;

    @JsonProperty("Limit")
    @ApiModelProperty("拉取数量")
    private String limit;

    @JsonProperty("Offset")
    @ApiModelProperty("拉取位移")
    private String offset;

    @JsonProperty("ResponseFilter")
    @ApiModelProperty("返回过滤器")
    private ResponseFilter responseFilter;
}
