package cn.zhoushilan.im.entity.request.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude( JsonInclude.Include.NON_NULL)
@Data
public class ApnsInfo{
    /**
     * 这个字段缺省或者为 0 表示需要计数，
     * 为 1 表示本条消息不需要计数，即右上角图标数字不增加
     */
    @JsonProperty("BadgeMode")
    private Integer badgeMode;
    /**
     * 离线推送声音文件路径。
     */
    @JsonProperty("Sound")
    private String sound;

    /**
     * 该字段用于标识apns推送的标题，若填写则会覆盖最上层Title
     */
    @JsonProperty("Title")
    private String title;

    /**
     * 该字段用于标识apns推送的子标题
     */
    @JsonProperty("SubTitle")
    private String subTitle;

    /**
     * 该字段用于标识apns携带的图片地址，当客户端拿到该字段时，
     * 可以通过下载图片资源的方式将图片展示在弹窗上
     */
    @JsonProperty("Image")
    private String image;


    @JsonProperty("MutableContent")
    private Integer mutableContent;
}