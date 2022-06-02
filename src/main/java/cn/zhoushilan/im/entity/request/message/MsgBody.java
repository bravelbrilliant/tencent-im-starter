package cn.zhoushilan.im.entity.request.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class MsgBody {

    /**
     * 消息元素类别；目前支持的消息对象包括：TIMTextElem(文本消息)，TIMFaceElem(表情消息)，
     * TIMLocationElem(位置消息)，TIMCustomElem(自定义消息)。
     */
    @JsonProperty("MsgType")
    private String msgType;

    /**
     * 消息内容
     */
    @JsonProperty("MsgContent")
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "MsgType")
    @JsonSubTypes(value = {@JsonSubTypes.Type(value = TextContent.class, name = "TIMTextElem"),
            @JsonSubTypes.Type(value = FileContent.class, name = "TIMFileElem"),
            @JsonSubTypes.Type(value = ImageContent.class, name = "TIMImageElem"),
            @JsonSubTypes.Type(value = SoundContent.class, name = "TIMSoundElem"),
            @JsonSubTypes.Type(value = VideoContent.class, name = "TIMVideoFileElem"),
            @JsonSubTypes.Type(value = RelayContent.class, name = "TIMRelayElem"),
            @JsonSubTypes.Type(value = CustomContent.class, name = "TIMCustomElem")})
    private MsgContent msgContent;


}
