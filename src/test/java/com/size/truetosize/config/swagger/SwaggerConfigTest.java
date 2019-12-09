package com.size.truetosize.config.swagger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SwaggerConfigTestSetup.class)
@TestPropertySource("classpath:application-test.properties")
public class SwaggerConfigTest {

    @Autowired
    private Docket docket;
    @Autowired
    private UiConfiguration uiConfiguration;

    @Test
    public void docket() {
        assertNotNull(docket);
    }

    @Test
    public void uiConfiguration() {
        assertNotNull(uiConfiguration);
    }
}
