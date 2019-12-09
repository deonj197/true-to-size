package com.size.truetosize.config;

import com.size.truetosize.mapper.ShoeMapper;
import com.size.truetosize.mapper.TrueToSizeMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ShoeMapper shoeMapper() {
        return Mappers.getMapper(ShoeMapper.class);
    }

    @Bean
    public TrueToSizeMapper trueToSizeMapper() {
        return Mappers.getMapper(TrueToSizeMapper.class);
    }
}
