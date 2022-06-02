package cn.zhoushilan.im.entity.request.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class TextContent extends MsgContent {
    /**
     * 消息内容。
     * 1、当接收方为iphone后台在线时，做iOS离线Push时文本展示。
     * 2、当接收方为iOS系统且应用处在后台时，json请求包体中的Text字段作为离线推送文本。
     */
    @JsonProperty("Text")
    private String text;

}
