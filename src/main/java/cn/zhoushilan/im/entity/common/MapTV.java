package cn.zhoushilan.im.entity.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MapTV {

    public MapTV(String tag, String value){
        this.tag = tag;
        this.value = value;
    }

    @ApiModelProperty("添加帐号")
    @JsonProperty("Tag")
    private String tag;

    @ApiModelProperty("添加帐号")
    @JsonProperty("Value")
    private  String value;
}
