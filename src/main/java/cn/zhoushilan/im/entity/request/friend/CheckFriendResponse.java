package cn.zhoushilan.im.entity.request.friend;

import cn.zhoushilan.im.entity.IMActionResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
public class CheckFriendResponse extends IMActionResponse {

    /**
     * 校验结果对象数组
     */
    @JsonProperty("InfoItem")
    private List<IMRelationItem> infoItem;

    /**
     * 处理失败的用户列表
     */
    @JsonProperty("Fail_Account")
    private List<String> failAccount;

}

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
class IMRelationItem {

    /**
     * 校验的用户的UserID
     */
    @JsonProperty("To_Account")
    private String toAccount;

    /**
     * 好友关系
     */
    @JsonProperty("Relation")
    private String relation;

    /**
     * 处理结果
     */
    @JsonProperty("ResultCode")
    private Integer resultCode;

    /**
     * 错误描述信息
     */
    @JsonProperty("ResultInfo")
    private String resultInfo;
}
