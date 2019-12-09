package com.size.truetosize.mockdata;

import com.size.truetosize.entity.TrueToSize;
import com.size.truetosize.model.TrueToSizeCalculation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrueToSizeMockData {
    public static final Long SHOE_ID = 100L;
    private static final Long TTS_ID = 1234L;
    private static final String SHOE_NAME = "air force one";

    public static com.size.truetosize.model.TrueToSize getTrueToSize() {
        final com.size.truetosize.model.TrueToSize trueToSize = new com.size.truetosize.model.TrueToSize();
        trueToSize.setTrueToSizeId(TTS_ID);
        trueToSize.setShoeId(SHOE_ID);
        trueToSize.setTrueToSizeValue(5L);
        return trueToSize;
    }

    public static List<com.size.truetosize.model.TrueToSize> getTrueToSizeList() {
        return Collections.singletonList(getTrueToSize());
    }

    public static TrueToSize getTrueToSizeEntity() {
        final TrueToSize trueToSize = new TrueToSize();
        trueToSize.setTrueToSizeId(TTS_ID);
        trueToSize.setShoeId(SHOE_ID);
        trueToSize.setTrueToSizeValue(5L);
        return trueToSize;
    }

    public static TrueToSize getTrueToSizeEntity(final Long ttsId, final Long ttsValue) {
        final TrueToSize trueToSize = new TrueToSize();
        trueToSize.setTrueToSizeId(ttsId);
        trueToSize.setShoeId(SHOE_ID);
        trueToSize.setTrueToSizeValue(ttsValue);
        return trueToSize;
    }

    public static List<TrueToSize> getTrueToSizeEntitiesForCalculation() {
        final List<TrueToSize> trueToSizeList = new ArrayList<>();
        trueToSizeList.add(getTrueToSizeEntity(1L, 5L));
        trueToSizeList.add(getTrueToSizeEntity(2L, 4L));
        trueToSizeList.add(getTrueToSizeEntity(3L, 3L));
        trueToSizeList.add(getTrueToSizeEntity(4L, 2L));
        trueToSizeList.add(getTrueToSizeEntity(5L, 1L));
        trueToSizeList.add(getTrueToSizeEntity(6L, 3L));
        trueToSizeList.add(getTrueToSizeEntity(7L, 1L));
        trueToSizeList.add(getTrueToSizeEntity(8L, 2L));
        trueToSizeList.add(getTrueToSizeEntity(9L, 4L));
        trueToSizeList.add(getTrueToSizeEntity(10L, 2L));
        return trueToSizeList;
    }

    public static TrueToSizeCalculation getExpectedTrueToSizeCalculation() {
        final TrueToSizeCalculation trueToSizeCalculation = new TrueToSizeCalculation();
        trueToSizeCalculation.setShoeId(SHOE_ID);
        trueToSizeCalculation.setShoeName(SHOE_NAME);
        trueToSizeCalculation.setTrueToSizeCalculationOutput(2.7);
        return trueToSizeCalculation;
    }

    public static List<TrueToSize> getTrueToSizeEntities() {
        return Collections.singletonList(getTrueToSizeEntity());
    }

    public static TrueToSizeCalculation getTrueToSizeCalculation() {
        final TrueToSizeCalculation trueToSizeCalculation = new TrueToSizeCalculation();
        trueToSizeCalculation.setShoeId(SHOE_ID);
        trueToSizeCalculation.setShoeName(SHOE_NAME);
        trueToSizeCalculation.setTrueToSizeCalculationOutput(5.0);
        return trueToSizeCalculation;
    }
}
