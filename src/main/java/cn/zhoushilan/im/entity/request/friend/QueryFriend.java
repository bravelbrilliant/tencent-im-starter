package cn.zhoushilan.im.entity.request.friend;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class QueryFriend {

    @ApiModelProperty("查询帐号")
    @JsonProperty("From_Account")
    private String fromAccount;

    @ApiModelProperty("分页其实位置")
    @JsonProperty("StartIndex")
    private Integer startIndex;

    @ApiModelProperty("添加好友的分组信息")
    @JsonProperty("StandardSequence")
    private Integer standardSequence;

    @ApiModelProperty("好友来源字段")
    @JsonProperty("CustomSequence")
    private Integer customSequence;


}
