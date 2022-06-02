package cn.zhoushilan.im.entity.callback.group;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExitGroupMemberRequest {

    @JsonProperty("CallbackCommand")
    @ApiModelProperty("回调命令")
    private String callbackCommand;

    @JsonProperty("GroupId")
    @ApiModelProperty("群Id")
    private String imGroupId;

    @JsonProperty("Operator_Account")
    @ApiModelProperty("操作者")
    private String operatorAccount;

    /**
     * 群类型
     * Work | Public | Meeting | AVChatRoom
     * the difference of them refer to: https://cloud.tencent.com/document/product/269/1502#GroupType
     */
    @JsonProperty("Type")
    @ApiModelProperty("类型")
    private String type;

    /**
     * 退群方式
     * Kicked(被踢) | Quit(主动退出)
     */
    @JsonProperty("ExitType")
    @ApiModelProperty("入群方式")
    private String exitType;

    @JsonProperty("ExitMemberList")
    @ApiModelProperty("成员列表")
    private List<Map<String, Long>> exitMemberList;
}