package com.size.truetosize.controller;

import com.size.truetosize.model.Shoe;
import com.size.truetosize.service.ShoeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.size.truetosize.mockdata.ShoeMockData.SHOE_ID;
import static com.size.truetosize.mockdata.ShoeMockData.getShoe;
import static com.size.truetosize.mockdata.ShoeMockData.getShoes;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ShoeControllerTest {

    @MockBean
    private ShoeService shoeService;

    private ShoeController shoeController;

    @Before
    public void setup() {
        shoeController = new ShoeController(shoeService);
    }

    @Test
    public void shouldCreateShoe() {
        final Shoe shoeModel = getShoe();
        when(shoeService.createShoe(shoeModel)).thenReturn(shoeModel);
        final Shoe newShoe = shoeController.createShoe(shoeModel);
        verify(shoeService).createShoe(shoeModel);
        assertEquals(shoeModel, newShoe);
    }

    @Test
    public void shouldGetAllShoes() {
        final List<Shoe> shoes = getShoes();
        when(shoeService.findAll()).thenReturn(shoes);
        final List<Shoe> foundShoes = shoeController.getAllShoes();
        verify(shoeService).findAll();
        assertEquals(shoes, foundShoes);
    }

    @Test
    public void shouldGetShoeById() {
        final Shoe shoe = getShoe();
        when(shoeService.findShoeById(SHOE_ID)).thenReturn(shoe);
        final Shoe foundShoe = shoeController.getShoeById(SHOE_ID);
        verify(shoeService).findShoeById(SHOE_ID);
        assertEquals(shoe, foundShoe);
    }
}
