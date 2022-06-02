package cn.zhoushilan.im.entity.request.group;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@JsonInclude( JsonInclude.Include.NON_NULL)
@Data
public class DestroyGroup {

    /**
     * 群组 ID 更加简单
     */
    @JsonProperty("GroupId")
    @ApiModelProperty("群ID")
    private String groupId;

}
