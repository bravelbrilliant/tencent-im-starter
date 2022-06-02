package cn.zhoushilan.im.entity.request.friend;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class AddFriend {
    /**
     * @program: pms
     * @description:
     * @author: Lee Ann
     * @create: 2021-01-29 10:33
     **/
    @ApiModelProperty("添加帐号")
    @JsonProperty("To_Account")
    private String toAccount;

    @ApiModelProperty("添加好友备注")
    @JsonProperty("Remark")
    private String remark;

    @ApiModelProperty("添加好友的分组信息")
    @JsonProperty("GroupName")
    private String groupName;

    /**
     * format: AddSource_Type_xxxxx
     * example: AddSource_Type_Android
     */
    @ApiModelProperty("好友来源字段")
    @JsonProperty("AddSource")
    private String addSource;

    /**
     * no more than 256 bytes
     */
    @ApiModelProperty("添加帐号")
    @JsonProperty("AddWording")
    private String addWording;

}
