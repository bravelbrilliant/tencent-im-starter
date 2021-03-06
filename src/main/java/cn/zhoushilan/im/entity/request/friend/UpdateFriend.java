package cn.zhoushilan.im.entity.request.friend;

import cn.zhoushilan.im.entity.common.MapTV;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class UpdateFriend {

    @ApiModelProperty("添加帐号")
    @JsonProperty("To_Account")
    private String toAccount;

    @ApiModelProperty("添加帐号")
    @JsonProperty("SnsItem")
    private List<MapTV> snsItem;

}
