package cn.zhoushilan.im.entity.request.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class FileContent extends MsgContent {

    @JsonProperty("FileName")
    private String fileName;

    @JsonProperty("FileSize")
    private Long fileSize;

    @JsonProperty("UUID")
    private String UUID;

    @JsonProperty("Url")
    private String url;

    @JsonProperty("FileId")
    private Long fileId;
}
