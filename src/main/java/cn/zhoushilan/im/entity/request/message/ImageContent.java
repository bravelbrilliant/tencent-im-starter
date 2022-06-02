package cn.zhoushilan.im.entity.request.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ImageContent extends MsgContent {

    @JsonProperty("UUID")
    private String UUID;

    @JsonProperty("ImageFormat")
    private Integer imageFormat;

    @JsonProperty("ImageInfoArray")
    private List<ImageInfo> imageInfoArray;

}
