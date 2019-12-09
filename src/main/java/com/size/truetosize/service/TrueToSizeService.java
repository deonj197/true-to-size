package com.size.truetosize.service;

import com.size.truetosize.entity.TrueToSize;
import com.size.truetosize.mapper.TrueToSizeMapper;
import com.size.truetosize.model.Shoe;
import com.size.truetosize.model.TrueToSizeCalculation;
import com.size.truetosize.repository.TrueToSizeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrueToSizeService {

    private final TrueToSizeRepository trueToSizeRepository;
    private final TrueToSizeMapper trueToSizeMapper;
    private final ShoeService shoeService;

    public com.size.truetosize.model.TrueToSize createTrueToSize(final com.size.truetosize.model.TrueToSize trueToSize) {
        final TrueToSize trueToSizeEntity = trueToSizeMapper.toEntity(trueToSize);
        final TrueToSize savedTrueToSize = this.saveTrueToSize(trueToSizeEntity);
        return trueToSizeMapper.toModel(savedTrueToSize);
    }

    private TrueToSize saveTrueToSize(final TrueToSize trueToSize) {
        return trueToSizeRepository.save(trueToSize);
    }

    public List<com.size.truetosize.model.TrueToSize> findAllByShoeId(final Long shoeId) {
        final List<TrueToSize> trueToSizeList = trueToSizeRepository.findByShoeId(shoeId);
        return trueToSizeMapper.toModels(trueToSizeList);
    }

    public TrueToSizeCalculation computeTrueToSizeCalculation(final Long shoeId) {
        final Shoe shoe = shoeService.findShoeById(shoeId);
        List<com.size.truetosize.model.TrueToSize> trueToSizeList = findAllByShoeId(shoeId);

        final TrueToSizeCalculation trueToSizeCalculation = new TrueToSizeCalculation();
        trueToSizeCalculation.setShoeId(shoeId);
        trueToSizeCalculation.setShoeName(shoe.getName());
        trueToSizeCalculation.setTrueToSizeCalculationOutput(calculateTrueToSizeValue(trueToSizeList));

        return trueToSizeCalculation;
    }

    private static Double calculateTrueToSizeValue(final List<com.size.truetosize.model.TrueToSize> trueToSizeList) {
        return trueToSizeList.stream()
                .mapToLong(com.size.truetosize.model.TrueToSize::getTrueToSizeValue)
                .average().orElse(Double.NaN);
    }
}
