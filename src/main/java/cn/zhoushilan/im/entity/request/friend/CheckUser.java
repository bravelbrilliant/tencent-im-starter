package cn.zhoushilan.im.entity.request.friend;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CheckUser {
    /**
     * @program: pms
     * @description:
     * @author: LXC
     * @create: 2021-03-08 19:42
     **/

    @ApiModelProperty("检验的用户")
    @JsonProperty("To_Account")
    private List<String> toAccount;

    @ApiModelProperty("是否需要详细信息")
    @JsonProperty("IsNeedDetail")
    private String isNeedDetail;


}
