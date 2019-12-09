package com.size.truetosize.service;

import com.size.truetosize.entity.Shoe;
import com.size.truetosize.exception.TrueToSizeException;
import com.size.truetosize.mapper.ShoeMapper;
import com.size.truetosize.repository.ShoeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShoeService {

    private final ShoeRepository shoeRepository;
    private final ShoeMapper shoeMapper;

    public com.size.truetosize.model.Shoe createShoe(final com.size.truetosize.model.Shoe shoe) {
        try {
            final Shoe shoeEntity = shoeMapper.toEntity(shoe);
            final Shoe savedEntity = this.saveShoe(shoeEntity);
            return shoeMapper.toModel(savedEntity);
        } catch (Exception exception) {
            log.error("Failed to create shoe with exception: {}", exception.getMessage());
            throw new TrueToSizeException(500, "Failed to create shoe with exception: %s", exception.getMessage());
        }
    }

    private Shoe saveShoe(final Shoe shoe) {
        return shoeRepository.save(shoe);
    }


    public com.size.truetosize.model.Shoe findShoeById(final Long shoeId) {
        try {
            return shoeMapper.toModel(shoeRepository.findById(shoeId)
                    .orElseThrow(() -> new RuntimeException("Shoe not found for shoeId: " + shoeId)));
        } catch (Exception exception) {
            log.error("Failed to find shoe with shoeId: {} with exception: {}", shoeId, exception.getMessage());
            throw new TrueToSizeException(500, "Failed to find shoe with shoeId: %d with exception: %s", shoeId, exception.getMessage());
        }
    }

    public List<com.size.truetosize.model.Shoe> findAll() {
        try {
            final List<Shoe> shoes = this.shoeRepository.findAll();
            return shoeMapper.toModels(shoes);
        } catch (Exception exception) {
            log.error("Failed to find all shoes with exception: {}", exception.getMessage());
            throw new TrueToSizeException(500, "Failed to find all shoes with exception: %s", exception.getMessage());
        }
    }
}
