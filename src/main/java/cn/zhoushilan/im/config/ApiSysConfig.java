package cn.zhoushilan.im.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class ApiSysConfig {

    @Value("${tengxunyun.im.baseUri}")
    private String baseUri;

    /**
     * App 在云通信控制台上获取的 Appid。
     */
    @Value("${tengxunyun.im.sdkAppId}")
    private Long sdkappid;

    /**
     * 用户名，调用 REST API 时一般为 App 管理员帐号。
     */
    @Value("${tengxunyun.im.adminName}")
    private String identifier;


    @Value("${tengxunyun.im.priKey}")
    private String priKey;

    @Value("${tengxunyun.im.userSigExpiration}")
    private Long userSigExpiration;

    /**
     * 用户名对应的签名。
     */
    private String usersig;

    /**
     * 标识当前请求的整数随机数参数。32 位无符号整数随机数。
     */
    private String random;

}
