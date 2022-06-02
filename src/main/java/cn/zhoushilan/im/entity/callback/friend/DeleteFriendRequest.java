package cn.zhoushilan.im.entity.callback.friend;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude( JsonInclude.Include.NON_NULL)
public class DeleteFriendRequest {

    /**
     * 回调命令
     */
    @JsonProperty("CallbackCommand")
    @ApiModelProperty("回调命令")
    private String callbackCommand;

    /**
     * 成功添加的好友列表
     */
    @JsonProperty("PairList")
    @ApiModelProperty("成功删除的好友")
    private List<DeleteFriendCallback> deleteFriendList;

}