package com.size.truetosize.service;

import com.size.truetosize.entity.Shoe;
import com.size.truetosize.mapper.ShoeMapper;
import com.size.truetosize.repository.ShoeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static com.size.truetosize.mockdata.ShoeMockData.SHOE_ID;
import static com.size.truetosize.mockdata.ShoeMockData.getShoe;
import static com.size.truetosize.mockdata.ShoeMockData.getShoeEntities;
import static com.size.truetosize.mockdata.ShoeMockData.getShoeEntity;
import static com.size.truetosize.mockdata.ShoeMockData.getShoes;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ShoeServiceTest {

    @MockBean
    private ShoeRepository shoeRepository;

    private ShoeService shoeService;

    @Before
    public void setup() {
        shoeService = new ShoeService(shoeRepository, Mappers.getMapper(ShoeMapper.class));
    }

    @Test
    public void shouldSaveShoe() {
        final com.size.truetosize.model.Shoe shoeMock = getShoe();
        final Shoe shoeEntity = getShoeEntity();
        when(shoeRepository.save(shoeEntity)).thenReturn(shoeEntity);
        final com.size.truetosize.model.Shoe savedShoe = shoeService.createShoe(shoeMock);
        verify(shoeRepository).save(shoeEntity);
        assertEquals(shoeMock, savedShoe);
    }

    @Test
    public void shouldGetAllShoes() {
        final List<Shoe> shoeEntities = getShoeEntities();
        final List<com.size.truetosize.model.Shoe> shoeModels = getShoes();
        when(shoeRepository.findAll()).thenReturn(shoeEntities);
        final List<com.size.truetosize.model.Shoe> shoes = shoeService.findAll();
        verify(shoeRepository).findAll();
        assertEquals(shoeModels, shoes);
    }

    @Test
    public void shouldFindShoeById() {
        final com.size.truetosize.model.Shoe shoe = getShoe();
        final Shoe shoeEntity = getShoeEntity();
        when(shoeRepository.findById(SHOE_ID)).thenReturn(Optional.of(shoeEntity));
        final com.size.truetosize.model.Shoe foundShoe = shoeService.findShoeById(SHOE_ID);
        verify(shoeRepository).findById(SHOE_ID);
        assertEquals(shoe, foundShoe);
    }
}
