package com.size.truetosize.config.swagger;

import com.size.truetosize.config.swagger.properties.SwaggerConfigProperties;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import({SwaggerConfig.class})
@TestConfiguration
public class SwaggerConfigTestSetup {
    @Bean
    public SwaggerConfigProperties swaggerConfigProperties() {
        return new SwaggerConfigProperties();
    }
}
