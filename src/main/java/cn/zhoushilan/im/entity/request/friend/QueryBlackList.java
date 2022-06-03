package cn.zhoushilan.im.entity.request.friend;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class QueryBlackList {

    @ApiModelProperty("查询帐号")
    @JsonProperty("From_Account")
    private String fromAccount;

    @ApiModelProperty("分页其实位置")
    @JsonProperty("StartIndex")
    private String startIndex;

    @ApiModelProperty("每页最多拉取数")
    @JsonProperty("MaxLimited")
    private String maxLimited;

    @ApiModelProperty("上次返回的最后一个sequence")
    @JsonProperty("LastSequence")
    private String lastSequence;


}
