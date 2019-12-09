package com.size.truetosize.mapper;

import com.size.truetosize.entity.TrueToSize;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TrueToSizeMapper {
    TrueToSize toEntity(final com.size.truetosize.model.TrueToSize trueToSize);

    com.size.truetosize.model.TrueToSize toModel(final TrueToSize trueToSize);

    List<com.size.truetosize.model.TrueToSize> toModels(final List<TrueToSize> trueToSize);
}
