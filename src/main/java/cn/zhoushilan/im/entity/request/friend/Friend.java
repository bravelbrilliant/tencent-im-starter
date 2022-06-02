package cn.zhoushilan.im.entity.request.friend;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Friend {
    /**
     * @program: pms
     * @description:
     * @author: Lee Ann
     * @create: 2021-01-29 10:27
     **/

    @ApiModelProperty("添加帐号")
    @JsonProperty("From_Account")
    private String fromAccount;

    /**
     * 添加好友方式
     * Add_Type_Single 表示单向加好友
     * Add_Type_Both 表示双向加好友
     */
    @ApiModelProperty("添加好友方式")
    @JsonProperty("AddType")
    private String addType;

    /**
     * 添加好友标记
     * 1表示强制加好友
     * 0表示常规加好友方式
     */
    @ApiModelProperty("添加好友标记")
    @JsonProperty("ForceAddFlags")
    private Integer forceAddFlags;

    @ApiModelProperty("被添加好友列表")
    @JsonProperty("AddFriendItem")
    private List<AddFriend> addFriendItem;

    @ApiModelProperty("被添加好友列表")
    @JsonProperty("UpdateItem")
    private List<UpdateFriend> updateItem;
}
