package com.size.truetosize.service;

import com.size.truetosize.entity.TrueToSize;
import com.size.truetosize.exception.TrueToSizeException;
import com.size.truetosize.mapper.TrueToSizeMapper;
import com.size.truetosize.model.Shoe;
import com.size.truetosize.model.TrueToSizeCalculation;
import com.size.truetosize.repository.TrueToSizeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrueToSizeService {

    private final TrueToSizeRepository trueToSizeRepository;
    private final TrueToSizeMapper trueToSizeMapper;
    private final ShoeService shoeService;

    public com.size.truetosize.model.TrueToSize createTrueToSize(final com.size.truetosize.model.TrueToSize trueToSize) {
        try {
            final TrueToSize trueToSizeEntity = trueToSizeMapper.toEntity(trueToSize);
            final TrueToSize savedTrueToSize = this.saveTrueToSize(trueToSizeEntity);
            return trueToSizeMapper.toModel(savedTrueToSize);
        } catch (Exception exception) {
            log.error("Failed to create true to size record with exception: {}", exception.getMessage());
            throw new TrueToSizeException(500, "Failed to create true to size record with exception: %s", exception.getMessage());
        }
    }

    private TrueToSize saveTrueToSize(final TrueToSize trueToSize) {
        return trueToSizeRepository.save(trueToSize);
    }

    public List<com.size.truetosize.model.TrueToSize> findAllByShoeId(final Long shoeId) {
        try {
            final List<TrueToSize> trueToSizeList = trueToSizeRepository.findByShoeId(shoeId);
            return trueToSizeMapper.toModels(trueToSizeList);
        } catch (Exception exception) {
            log.error("Failed to find all true to size records for shoeId: {} with exception: {}", shoeId, exception.getMessage());
            throw new TrueToSizeException(500, "Failed to find all true to size records for shoeId: %d with exception: %s", shoeId, exception.getMessage());
        }
    }

    public TrueToSizeCalculation computeTrueToSizeCalculation(final Long shoeId) {
        try {
            final Shoe shoe = shoeService.findShoeById(shoeId);
            List<com.size.truetosize.model.TrueToSize> trueToSizeList = findAllByShoeId(shoeId);

            final TrueToSizeCalculation trueToSizeCalculation = new TrueToSizeCalculation();
            trueToSizeCalculation.setShoeId(shoeId);
            trueToSizeCalculation.setShoeName(shoe.getName());
            trueToSizeCalculation.setTrueToSizeCalculationOutput(calculateTrueToSizeValue(trueToSizeList));

            return trueToSizeCalculation;
        } catch (Exception exception) {
            log.error("Failed to compute true to size calculation for shoeId: {} with exception: {}", shoeId, exception.getMessage());
            throw new TrueToSizeException(500, "Failed to compute true to size calculation for shoeId: %d with exception: %s", shoeId, exception.getMessage());
        }
    }

    private static Double calculateTrueToSizeValue(final List<com.size.truetosize.model.TrueToSize> trueToSizeList) {
        return trueToSizeList.stream()
                .mapToLong(com.size.truetosize.model.TrueToSize::getTrueToSizeValue)
                .average().orElse(Double.NaN);
    }
}
