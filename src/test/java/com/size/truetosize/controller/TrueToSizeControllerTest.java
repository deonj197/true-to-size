package com.size.truetosize.controller;

import com.size.truetosize.model.TrueToSize;
import com.size.truetosize.model.TrueToSizeCalculation;
import com.size.truetosize.service.TrueToSizeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.size.truetosize.mockdata.TrueToSizeMockData.SHOE_ID;
import static com.size.truetosize.mockdata.TrueToSizeMockData.getTrueToSize;
import static com.size.truetosize.mockdata.TrueToSizeMockData.getTrueToSizeCalculation;
import static com.size.truetosize.mockdata.TrueToSizeMockData.getTrueToSizeList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class TrueToSizeControllerTest {

    @MockBean
    private TrueToSizeService trueToSizeService;

    private TrueToSizeController trueToSizeController;

    @Before
    public void setup() {
        trueToSizeController = new TrueToSizeController(trueToSizeService);
    }

    @Test
    public void shouldCreateTrueToSize() {
        final TrueToSize trueToSizeModel = getTrueToSize();
        when(trueToSizeService.createTrueToSize(trueToSizeModel)).thenReturn(trueToSizeModel);
        final TrueToSize newTrueToSize =  trueToSizeController.createTrueToSize(trueToSizeModel);
        verify(trueToSizeService).createTrueToSize(trueToSizeModel);
        assertEquals(trueToSizeModel, newTrueToSize);
    }

    @Test
    public void shouldGetAllTrueToSize() {
        final List<TrueToSize> trueToSizeList = getTrueToSizeList();
        when(trueToSizeService.findAllByShoeId(SHOE_ID)).thenReturn(trueToSizeList);
        final List<TrueToSize> trueToSizeOuput = trueToSizeController.getAllTrueToSize(SHOE_ID);
        verify(trueToSizeService).findAllByShoeId(SHOE_ID);
        assertEquals(trueToSizeList, trueToSizeOuput);
    }

    @Test
    public void shouldGetTrueToSizeCalculation() {
        final TrueToSizeCalculation mockCalculation = getTrueToSizeCalculation();
        when(trueToSizeService.computeTrueToSizeCalculation(SHOE_ID)).thenReturn(mockCalculation);
        final TrueToSizeCalculation calculation = trueToSizeController.getTrueToSizeCalculation(SHOE_ID);
        verify(trueToSizeService).computeTrueToSizeCalculation(SHOE_ID);
        assertEquals(mockCalculation, calculation);
    }
}
