package cn.zhoushilan.im.entity.request.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class SoundContent extends MsgContent {

    @JsonProperty("second")
    private Integer second;

    @JsonProperty("Size")
    private Long size;

    @JsonProperty("UUID")
    private String UUID;
    
    @JsonProperty("Url")
    private String url;

    @JsonProperty("FileId")
    private Long fileId;
}
