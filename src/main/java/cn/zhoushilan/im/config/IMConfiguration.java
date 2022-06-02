package cn.zhoushilan.im.config;

import cn.zhoushilan.im.helper.TencentIMHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IMConfiguration {

    @Bean
    public TencentIMHelper tencentIMHelper() {
        return new TencentIMHelper();
    }
}