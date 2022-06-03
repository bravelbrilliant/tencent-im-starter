package cn.zhoushilan.im.entity.request.friend;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class DeleteFriend {

    @ApiModelProperty("删除人帐号")
    @JsonProperty("From_Account")
    private String fromAccount;

    @ApiModelProperty("被删除好友账号列表")
    @JsonProperty("To_Account")
    private List<String> toAccount;

    /**
     * Delete_Type_Single 单项删除
     * Delete_Type_Both 双向删除
     */
    @ApiModelProperty("删除类型")
    @JsonProperty("DeleteType")
    private String deleteType;
}
