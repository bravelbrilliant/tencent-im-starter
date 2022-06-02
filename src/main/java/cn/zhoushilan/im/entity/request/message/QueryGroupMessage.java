package cn.zhoushilan.im.entity.request.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class QueryGroupMessage {

    @JsonProperty("GroupId")
    @ApiModelProperty("群ID")
    private String groupId;

    /**
     * 返回的序列号
     */
    @JsonProperty("ReqMsgSeq")
    @ApiModelProperty("返回的序列号")
    private Long reqMsgSeq;

    /**
     * 一次拉取的数量，最多一次20条
     */
    @JsonProperty("ReqMsgNumber")
    @ApiModelProperty("一次拉取的数量")
    private Integer reqMsgNumber;


}
