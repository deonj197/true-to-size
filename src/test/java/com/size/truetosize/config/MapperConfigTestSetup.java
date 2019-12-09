package com.size.truetosize.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;

@Import({MapperConfig.class})
@TestConfiguration
public class MapperConfigTestSetup {
}
