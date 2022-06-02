package cn.zhoushilan.im.entity.request.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class RelayContent extends MsgContent {

    @JsonProperty("Title")
    private String title;

    @JsonProperty("MsgNum")
    private Integer msgNum;

    @JsonProperty("CompatibleText")
    private String compatibleText;

    @JsonProperty("AbstractList")
    private List<String> abstractList;

    @JsonProperty("MsgList")
    private List<MsgBodyWrapper> msgList;


   @Data
    public class MsgBodyWrapper{

        @JsonProperty("GroupId")
        private String groupId;

        @JsonProperty("MsgTimeStamp")
        private Long msgTimeStamp;

        @JsonProperty("From_AccountNick")
        private String fromAccountNick;

        @JsonProperty("From_AccountHeadurl")
        private String fromAccountHeadurl;

        @JsonProperty("MsgList")
        private List<MsgBody> MsgBody;

    }
}


