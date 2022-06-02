package cn.zhoushilan.im.entity.request.group;

import cn.zhoushilan.im.entity.common.MapKV;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class AppMember {

    /**
     * 成员账号
     */
    @JsonProperty("Member_Account")
    @ApiModelProperty("成员账号")
    private String memberAccount;

    /**
     * 赋予该成员的身份，目前备选项只有Admin（选填）
     */
    @JsonProperty("Role")
    @ApiModelProperty("群身份")
    private String role;

    /**
     * 入群时间
     */
    @JsonProperty("JoinTime")
    @ApiModelProperty("入群时间")
    private String joinTime;


    /**
     * 未读信息
     */
    @JsonProperty("UnreadMsgNum")
    @ApiModelProperty("未读信息")
    private String unreadMsgNum;


    /**
     * 群成员维度自定义字段（选填）
     */
    @JsonProperty("AppMemberDefinedData")
    @ApiModelProperty("群成员自定义维度")
    private List<MapKV> appMemberDefinedData;

}
