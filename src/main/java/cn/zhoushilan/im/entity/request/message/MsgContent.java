package cn.zhoushilan.im.entity.request.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class MsgContent {

    /**
     * 额外数据
     */
    @JsonProperty("Data")
    private String data;
}
