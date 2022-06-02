package cn.zhoushilan.im.entity.request.user;

import cn.zhoushilan.im.entity.common.MapTV;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class PortraitSetItems {

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID", name = "fromAccount")
    @JsonProperty("From_Account")
    private String fromAccount;

    /**
     * 待设置的用户的资料对象数组
     */
    @ApiModelProperty(value = "待设置的用户的资料对象数组", name = "profileItem")
    @JsonProperty("ProfileItem")
    private List<MapTV> profileItem;

}
