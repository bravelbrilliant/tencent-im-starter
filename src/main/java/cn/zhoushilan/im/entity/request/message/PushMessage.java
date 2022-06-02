package cn.zhoushilan.im.entity.request.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class PushMessage {


    /**
     * 消息发送方帐号。（用于指定发送消息方帐号）
     */
    @JsonProperty("From_Account")
    private String fromAccount;


    /**
     * 消息离线保存时长（秒数），最长为 7 天（604800s）。
     * 若消息只发在线用户，不想保存离线，则该字段填 0。若不填，则默认保存 7 天
     */
    @JsonProperty("MsgLifeTime")
    private Integer msgLifeTime;

    /**
     * 消息随机数,由随机函数产生。（用作消息去重）
     */
    @JsonProperty("MsgRandom")
    private Integer msgRandom;


    /**
     * 消息信息
     */
    @JsonProperty("MsgBody")
    private List<MsgBody> msgBody;

    @JsonProperty("Condition")
    private Condition condition;

    /**
     * 离线信息设置
     */
    @JsonProperty("OfflinePushInfo")
    private OfflinePushInfo offlinePushInfo;

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
class Condition {

    @JsonProperty("AttrsAnd")
    private Map<String,String> attrsAnd;

    @JsonProperty("AttrsOr")
    private Map<String,String> attrsOr;

    @JsonProperty("TagsOr")
    private List<String> tagsOr;

    @JsonProperty("TagsAnd")
    private List<String> tagsAnd;
}
