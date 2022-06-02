package cn.zhoushilan.im.entity.request.group;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ImportAppMember {

    /**
     * 群组 ID 更加简单
     */
    @JsonProperty("GroupId")
    @ApiModelProperty("群ID")
    private String groupId;

    @JsonProperty("MemberList")
    @ApiModelProperty("成员列表")
    private List<AppMember> memberList;

}
