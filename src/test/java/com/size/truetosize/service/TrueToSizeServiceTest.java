package com.size.truetosize.service;

import com.size.truetosize.entity.TrueToSize;
import com.size.truetosize.mapper.TrueToSizeMapper;
import com.size.truetosize.model.TrueToSizeCalculation;
import com.size.truetosize.repository.TrueToSizeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.size.truetosize.mockdata.ShoeMockData.getShoe;
import static com.size.truetosize.mockdata.TrueToSizeMockData.SHOE_ID;
import static com.size.truetosize.mockdata.TrueToSizeMockData.getExpectedTrueToSizeCalculation;
import static com.size.truetosize.mockdata.TrueToSizeMockData.getTrueToSize;
import static com.size.truetosize.mockdata.TrueToSizeMockData.getTrueToSizeEntities;
import static com.size.truetosize.mockdata.TrueToSizeMockData.getTrueToSizeEntitiesForCalculation;
import static com.size.truetosize.mockdata.TrueToSizeMockData.getTrueToSizeEntity;
import static com.size.truetosize.mockdata.TrueToSizeMockData.getTrueToSizeList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class TrueToSizeServiceTest {

    @MockBean
    private TrueToSizeRepository trueToSizeRepository;

    @MockBean
    private ShoeService shoeService;

    private TrueToSizeService trueToSizeService;

    @Before
    public void setup() {
        trueToSizeService = new TrueToSizeService(trueToSizeRepository, Mappers.getMapper(TrueToSizeMapper.class), shoeService);
    }

    @Test
    public void shouldSaveTrueToSize() {
        final TrueToSize trueToSizeEntity = getTrueToSizeEntity();
        final com.size.truetosize.model.TrueToSize trueToSizeModel = getTrueToSize();
        when(trueToSizeRepository.save(trueToSizeEntity)).thenReturn(trueToSizeEntity);
        final com.size.truetosize.model.TrueToSize savedTrueToSize = trueToSizeService.createTrueToSize(trueToSizeModel);
        verify(trueToSizeRepository).save(trueToSizeEntity);
        assertEquals(trueToSizeModel, savedTrueToSize);
    }

    @Test
    public void shouldFindAllByShoeId() {
        final List<com.size.truetosize.model.TrueToSize> trueToSizeList = getTrueToSizeList();
        when(trueToSizeRepository.findByShoeId(SHOE_ID)).thenReturn(getTrueToSizeEntities());
        final List<com.size.truetosize.model.TrueToSize> trueToSizeOutput = trueToSizeService.findAllByShoeId(SHOE_ID);
        verify(trueToSizeRepository).findByShoeId(SHOE_ID);
        assertEquals(trueToSizeList, trueToSizeOutput);
    }

    @Test
    public void shouldComputeTrueToSizeCalculation() {
        when(trueToSizeRepository.findByShoeId(SHOE_ID)).thenReturn(getTrueToSizeEntitiesForCalculation());
        when(shoeService.findShoeById(SHOE_ID)).thenReturn(getShoe());
        final TrueToSizeCalculation trueToSizeCalculation = trueToSizeService.computeTrueToSizeCalculation(SHOE_ID);
        verify(trueToSizeRepository).findByShoeId(SHOE_ID);
        assertEquals(getExpectedTrueToSizeCalculation(), trueToSizeCalculation);
    }
}
