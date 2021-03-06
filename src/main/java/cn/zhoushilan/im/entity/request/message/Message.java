package cn.zhoushilan.im.entity.request.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Message {

    /**
     * 1：把消息同步到 From_Account 在线终端和漫游上；
     * 2：消息不同步至 From_Account；若不填写默认情况下会将消息存 From_Account 漫游
     */
    @JsonProperty("SyncOtherMachine")
    private Integer syncOtherMachine;

    /**
     * 消息发送方帐号。（用于指定发送消息方帐号）
     */
    @JsonProperty("From_Account")
    private String fromAccount;

    /**
     * 消息接收方帐号。
     */
    @JsonProperty("To_Account")
    private String toAccount;

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
     * 消息时间戳，unix 时间戳。
     */
    @JsonProperty("MsgTimeStamp")
    private Long msgTimeStamp;

    /**
     * 消息信息
     */
    @JsonProperty("MsgBody")
    private List<MsgBody> msgBody;

    /**
     * 离线信息设置
     */
    @JsonProperty("OfflinePushInfo")
    private OfflinePushInfo offlinePushInfo;

}
