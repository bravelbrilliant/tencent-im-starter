package cn.zhoushilan.im.entity.request.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude( JsonInclude.Include.NON_NULL)
@Data
public class OfflinePushInfo {

    /**
     * 0表示推送，1表示不离线推送。
     */
    @JsonProperty("PushFlag")
    private Integer pushFlag;

    /**
     * 离线推送标题。该字段为ios和android共用
     */
    @JsonProperty("Title")
    private String title;

    /**
     * 离线推送内容 。
     */
    @JsonProperty("Desc")
    private String desc;

    /**
     * 离线推送透传内容。
     */
    @JsonProperty("Ext")
    private String ext;

    @JsonProperty("ApnsInfo")
    private ApnsInfo apnsInfo;

    @JsonProperty("AndroidInfo")
    private AndroidInfo androidInfo;


}
