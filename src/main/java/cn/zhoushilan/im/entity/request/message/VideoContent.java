package cn.zhoushilan.im.entity.request.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class VideoContent extends MsgContent {

    @JsonProperty("VideoSize")
    private Long videoSize;

    @JsonProperty("VideoSecond")
    private Integer videoSecond;

    @JsonProperty("VideoFormat")
    private String videoFormat;

    @JsonProperty("ThumbSize")
    private Long thumbSize;

    @JsonProperty("ThumbWidth")
    private Integer thumbWidth;

    @JsonProperty("ThumbHeight")
    private Integer thumbHeight;


    @JsonProperty("VideoUUID")
    private String videoUUID;

    @JsonProperty("VideoUrl")
    private String videoUrl;

    @JsonProperty("FileId")
    private Long fileId;

    @JsonProperty("ThumbUUID")
    private String thumbUUID;

    @JsonProperty("ThumbUrl")
    private String thumbUrl;

    @JsonProperty("ThumbFileId")
    private Long thumbFileId;

}
