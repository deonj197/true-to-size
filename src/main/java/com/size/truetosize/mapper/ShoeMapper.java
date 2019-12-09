package com.size.truetosize.mapper;

import com.size.truetosize.entity.Shoe;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ShoeMapper {
    Shoe toEntity(final com.size.truetosize.model.Shoe shoe);

    com.size.truetosize.model.Shoe toModel(final Shoe shoe);

    List<com.size.truetosize.model.Shoe> toModels(final List<Shoe> shoes);
}
