package com.size.truetosize.config;

import com.size.truetosize.mapper.ShoeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MapperConfigTestSetup.class)
@TestPropertySource("classpath:application-test.properties")
public class MapperConfigTest {

    @Autowired
    private ShoeMapper shoeMapper;

    @Test
    public void setShoeMapper() {
        assertNotNull(shoeMapper);
    }
}
