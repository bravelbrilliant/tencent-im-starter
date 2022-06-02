package cn.zhoushilan.im.entity.request.group;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class QueryGroupDetail {

    /**
     * 本次获取的群组 ID 数量的上限，不得超过 10000。如果不填，默认为最大值 10000。
     */
    @JsonProperty("GroupIdList")
    @ApiModelProperty("群组ID列表")
    private List<String> groupIdList;

    @JsonProperty("ResponseFilter")
    @ApiModelProperty("返回过滤器")
    private ResponseFilter responseFilter;
}
