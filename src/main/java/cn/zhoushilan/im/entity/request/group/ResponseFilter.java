package cn.zhoushilan.im.entity.request.group;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ResponseFilter {

    @JsonProperty("GroupBaseInfoFilter")
    @ApiModelProperty("基础信息过滤")
    private List<String> groupBaseInfoFilter;

    @JsonProperty("MemberInfoFilter")
    @ApiModelProperty("成员信息过滤")
    private List<String> memberInfoFilter;

    @JsonProperty("AppDefinedDataFilter_Group")
    @ApiModelProperty("群维度自定义过滤")
    private List<String> appDefinedDataFilterGroup;

    @JsonProperty("AppDefinedDataFilter_GroupMember")
    @ApiModelProperty("群成员维度自定义过滤")
    private List<String> appDefinedDataFilterGroupMember;

    /**
     * 用户在群中的信息，用于获取用户所加入群组查询接口
     */
    @JsonProperty("selfInfoFilter")
    @ApiModelProperty("成员信息过滤")
    private List<String> SelfInfoFilter;

}
