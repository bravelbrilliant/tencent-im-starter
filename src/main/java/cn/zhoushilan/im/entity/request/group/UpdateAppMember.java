package cn.zhoushilan.im.entity.request.group;

import cn.zhoushilan.im.entity.common.MapKV;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class UpdateAppMember {


    @JsonProperty("GroupId")
    @ApiModelProperty("群组id")
    private String groupId;

    @JsonProperty("Member_Account")
    @ApiModelProperty("群成员ID")
    private String memberAccount;

    @JsonProperty("Role")
    @ApiModelProperty("成员身份")
    private String role;

    @JsonProperty("MsgFlag")
    @ApiModelProperty("消息屏蔽类型")
    private String MsgFlag;

    @JsonProperty("NameCard")
    @ApiModelProperty("群名片")
    private String nameCard;

    /**
     * 需要禁言时间，0代表取消禁言
     */
    @JsonProperty("ShutUpTime")
    @ApiModelProperty("需要禁言时间")
    private String shutUpTime;

    /**
     * 群成员维度自定义字段（选填）
     */
    @JsonProperty("AppMemberDefinedData")
    @ApiModelProperty("群成员自定义维度")
    private List<MapKV> appMemberDefinedData;

}
