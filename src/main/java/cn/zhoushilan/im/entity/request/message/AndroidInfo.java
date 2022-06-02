package cn.zhoushilan.im.entity.request.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude( JsonInclude.Include.NON_NULL)
@Data
public class AndroidInfo {


    /**
     * 离线推送声音文件路径。
     */
    @JsonProperty("Sound")
    private String sound;

    @JsonProperty("HuaWeiChannelID")
    private String huaWeiChannelID;

    @JsonProperty("XiaoMiChannelID")
    private String xiaoMiChannelID;

    @JsonProperty("OPPOChannelID")
    private String oppoChannelID;

    @JsonProperty("ChannelID")
    private String channelID;

    @JsonProperty("NotificationChannel")
    private String notificationChannel;

    @JsonProperty("ExtAsHuaweiIntentParam")
    private Integer extAsHuaweiIntentParam;

    @JsonProperty("HuaWeiImportance")
    private String huaWeiImportance;

    @JsonProperty("VIVOClassification")
    private Integer vivoClassification;

}