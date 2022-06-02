package cn.zhoushilan.im.entity.request.group;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@JsonInclude( JsonInclude.Include.NON_NULL)
@Data
public class NewGroupOwner {

    /**
     * 群主 id，自动添加到群成员中。如果不填，群没有群主。
     */
    @JsonProperty("NewOwner_Account")
    @ApiModelProperty("群主")
    private String newOwnerAccount;

    /**
     * 群组 ID 更加简单
     */
    @JsonProperty("GroupId")
    @ApiModelProperty("群ID")
    private String groupId;
}
