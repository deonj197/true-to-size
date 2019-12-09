package com.size.truetosize.mockdata;

import com.size.truetosize.model.Shoe;

import java.util.Collections;
import java.util.List;

public class ShoeMockData {
    public static final Long SHOE_ID = 100L;
    private static final String SHOE_NAME = "air force one";

    public static Shoe getShoe() {
        final Shoe shoe = new Shoe();
        shoe.setShoeId(SHOE_ID);
        shoe.setName(SHOE_NAME);
        return shoe;
    }

    public static com.size.truetosize.entity.Shoe getShoeEntity() {
        final com.size.truetosize.entity.Shoe shoe = new com.size.truetosize.entity.Shoe();
        shoe.setShoeId(SHOE_ID);
        shoe.setName(SHOE_NAME);
        return shoe;
    }

    public static List<Shoe> getShoes() {
        return Collections.singletonList(getShoe());
    }

    public static List<com.size.truetosize.entity.Shoe> getShoeEntities() {
        return Collections.singletonList(getShoeEntity());
    }
}
