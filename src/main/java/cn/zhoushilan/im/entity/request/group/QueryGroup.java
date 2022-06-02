package cn.zhoushilan.im.entity.request.group;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class QueryGroup {

    /**
     * 本次获取的群组 ID 数量的上限，不得超过 10000。如果不填，默认为最大值 10000。
     */
    @JsonProperty("Limit")
    @ApiModelProperty("获取上限")
    private Integer limit;

    /**
     * 群太多时分页拉取标志，第一次填 0，以后填上一次返回的值，返回的 Next 为 0 代表拉完了。
     */
    @JsonProperty("Next")
    @ApiModelProperty("上一次返回值")
    private Long next;

    /**
     * 群组形态的群组
     * Public（公开群），
     * Private（私密群），
     * ChatRoom（聊天室），
     * AVChatRoom（互动直播聊天室）
     * BChatRoom（在线成员广播大群）
     */
    @JsonProperty("GroupType")
    @ApiModelProperty("群类型")
    private String groupType;
}
