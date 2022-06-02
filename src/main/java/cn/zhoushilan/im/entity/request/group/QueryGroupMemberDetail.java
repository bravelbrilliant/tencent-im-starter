package cn.zhoushilan.im.entity.request.group;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class QueryGroupMemberDetail {

    /**
     * 本次获取的群组 ID 数量的上限，不得超过 10000。如果不填，默认为最大值 10000。
     */
    @JsonProperty("GroupId")
    @ApiModelProperty("群组ID列表")
    private String groupId;

    @JsonProperty("Limit")
    @ApiModelProperty("拉取数量")
    private String limit;

    @JsonProperty("Offset")
    @ApiModelProperty("拉取位移")
    private String offset;

    @JsonProperty("MemberInfoFilter")
    @ApiModelProperty("成员信息过滤器")
    private List<String> memberInfoFilter;

    @JsonProperty("MemberRoleFilter")
    @ApiModelProperty("成员身份过滤器")
    private List<String> memberRoleFilter;

    @JsonProperty("AppDefinedDataFilter_GroupMember")
    @ApiModelProperty("成员自定义字段过滤器")
    private List<String> appDefinedDataFilterGroupMember;
}
