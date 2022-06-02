package cn.zhoushilan.im.entity.callback.group;

import cn.zhoushilan.im.entity.common.MapKV;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChatGroupRequest {

    @JsonProperty("CallbackCommand")
    @ApiModelProperty("回调命令")
    private String callbackCommand;

    @JsonProperty("GroupId")
    @ApiModelProperty("群Id")
    private String imGroupId;

    @JsonProperty("Operator_Account")
    @ApiModelProperty("操作者")
    private String operatorAccount;

    @JsonProperty("Owner_Account")
    @ApiModelProperty("群主")
    private String ownerAccount;

    /**
     * 群类型
     * Work | Public | Meeting | AVChatRoom
     * the difference of them refer to: https://cloud.tencent.com/document/product/269/1502#GroupType
     */
    @JsonProperty("Type")
    @ApiModelProperty("类型")
    private String type;

    /**
     * 入群方式
     * Apply(申请) | Invited(邀请)
     */
    @JsonProperty("JoinType")
    @ApiModelProperty("入群方式")
    private String joinType;

    @JsonProperty("Name")
    @ApiModelProperty("类型")
    private String name;

    @JsonProperty("Introduction")
    @ApiModelProperty("简介")
    private String introduction;

    @JsonProperty("Notification")
    @ApiModelProperty("公告")
    private String notification;

    @JsonProperty("FaceUrl")
    @ApiModelProperty("群头像")
    private String faceUrl;

    @JsonProperty("MemberList")
    @ApiModelProperty("成员列表")
    private List<Map<String, Long>> memberList;

    @JsonProperty("AppDefinedData")
    @ApiModelProperty("自定义字段")
    private List<MapKV> appDefinedData;
}