package cn.zhoushilan.im.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class IMActionResponse {

    public IMActionResponse(){

    }

    /**
     * 请求处理的结果，OK 表示处理成功，FAIL 表示失败。
     */
    @JsonProperty("ActionStatus")
    @ApiModelProperty("请求处理的结果")
    private String actionStatus;

    /**
     * 错误信息。
     */
    @JsonProperty("ErrorInfo")
    @ApiModelProperty("错误信息")
    private String errorInfo;

    /**
     * 错误码。
     */
    @JsonProperty("ErrorCode")
    @ApiModelProperty("错误码")
    private int errorCode;

    /**
     * 展示信息
     */
    @JsonProperty("ErrorDisplay")
    @ApiModelProperty("展示信息")
    private String errorDisplay;

    IMActionResponse(String actionStatus, int errorCode, String errorInfo){
        this.actionStatus = actionStatus;
        this.errorCode = errorCode;
        this.errorInfo = errorInfo;
    }

    public boolean isSuccess() {
        return "OK".equals(actionStatus);
    }

    public static IMActionResponse success(){
        return new IMActionResponse("OK", 0, "");
    }

    public static IMActionResponse failed(String message){
        return new IMActionResponse("FAIL", 1, message);
    }
}
