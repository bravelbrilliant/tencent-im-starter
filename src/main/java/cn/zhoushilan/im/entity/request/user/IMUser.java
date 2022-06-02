package cn.zhoushilan.im.entity.request.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel
public class IMUser {

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID", name = "UserID")
    @JsonProperty("UserID")
    private String userID;

    /**
     * 用户名，长度不超过 32 字节
     */
    @ApiModelProperty(value = "用户名", name = "identifier")
    @JsonProperty("Identifier")
    private String identifier;

    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称", name = "Nick")
    @JsonProperty("Nick")
    private String nick;
    /**
     * 用户头像URL。
     */
    @ApiModelProperty(value = "用户头像", name = "FaceUrl")
    @JsonProperty("FaceUrl")
    private String faceUrl;

    public IMUser() {
    }

    public IMUser(String identifier, String nick, String faceUrl) {
        this.identifier = identifier;
        this.nick = nick;
        this.faceUrl = faceUrl;
    }

}
