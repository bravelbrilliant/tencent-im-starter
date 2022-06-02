package cn.zhoushilan.im.entity.callback.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class StateChangeRequest {

    @ApiModelProperty("消息")
    @JsonProperty("Info")
    private Map<String,String> info;

    @ApiModelProperty("触发回调的时间戳")
    @JsonProperty("EventTime")
    private String eventTime;

    @ApiModelProperty("提出设备信息")
    @JsonProperty("KickedDevice")
    private List<Map<String,String>> kickedDevice;

}
