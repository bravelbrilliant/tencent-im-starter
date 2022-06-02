package cn.zhoushilan.im.entity.request.group;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class AddAppMember {


    @JsonProperty("GroupId")
    @ApiModelProperty("群组id")
    private String groupId;

    /**
     * 0：非静默加人；1：静默加人，该字段默认为0
     */
    @JsonProperty("Silence")
    @ApiModelProperty("是否是静默加人")
    private Integer silence;

    /**
     * 群成员维度自定义字段（选填）
     */
    @JsonProperty("MemberList")
    @ApiModelProperty("群成员自定义维度")
    private List<AppMember> memberList;

}
