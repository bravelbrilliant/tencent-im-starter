package cn.zhoushilan.im.entity.request.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ImageInfo {

    @JsonProperty("Type")
    private Integer type;

    @JsonProperty("Width")
    private Integer width;

    @JsonProperty("Height")
    private Integer height;

    @JsonProperty("URL")
    private String url;

    @JsonProperty("Size")
    private Long size;

    @JsonProperty("FileId")
    private Long fileId;

}

