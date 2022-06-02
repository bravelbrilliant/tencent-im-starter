package cn.zhoushilan.im.entity.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class MapKV {

    @ApiModelProperty("添加帐号")
    @JsonProperty("Key")
    private String key;

    @ApiModelProperty("添加帐号")
    @JsonProperty("Value")
    private String value;
}
