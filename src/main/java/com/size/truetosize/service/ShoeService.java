package com.size.truetosize.service;

import com.size.truetosize.entity.Shoe;
import com.size.truetosize.mapper.ShoeMapper;
import com.size.truetosize.repository.ShoeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoeService {

    private final ShoeRepository shoeRepository;
    private final ShoeMapper shoeMapper;

    public com.size.truetosize.model.Shoe createShoe(final com.size.truetosize.model.Shoe shoe) {
        final Shoe shoeEntity = shoeMapper.toEntity(shoe);
        final Shoe savedEntity = this.saveShoe(shoeEntity);
        return shoeMapper.toModel(savedEntity);
    }

    private Shoe saveShoe(final Shoe shoe) {
        return shoeRepository.save(shoe);
    }


    public com.size.truetosize.model.Shoe findShoeById(final Long shoeId) {
        return shoeMapper.toModel(shoeRepository.findById(shoeId)
                .orElseThrow(() -> new RuntimeException("Shoe not found for shoeId: " + shoeId)));
    }

    public List<com.size.truetosize.model.Shoe> findAll() {
        final List<Shoe> shoes = this.shoeRepository.findAll();
        return shoeMapper.toModels(shoes);
    }
}
