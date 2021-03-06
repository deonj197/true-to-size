package com.size.truetosize.controller;

import com.size.truetosize.model.TrueToSize;
import com.size.truetosize.model.TrueToSizeCalculation;
import com.size.truetosize.service.TrueToSizeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TrueToSizeController {

    private final TrueToSizeService trueToSizeService;

    @PostMapping("/trueToSize")
    public TrueToSize createTrueToSize(@RequestBody final com.size.truetosize.model.TrueToSize trueToSize) {
        log.info("Starting POST /trueToSize");
        final TrueToSize savedTrueToSize = trueToSizeService.createTrueToSize(trueToSize);
        log.info("Finishing POST /trueToSize");
        return savedTrueToSize;
    }

    @GetMapping("/trueToSize/{shoe_id}")
    public List<TrueToSize> getAllTrueToSize(@PathVariable(value = "shoe_id") final Long shoeId) {
        log.info("Starting GET /trueToSize/{shoe_id} for shoe_id: {}", shoeId);
        final List<TrueToSize> trueToSizeList = trueToSizeService.findAllByShoeId(shoeId);
        log.info("Finishing GET /trueToSize/{shoe_id} for shoe_id: {}", shoeId);
        return trueToSizeList;
    }

    @GetMapping("/trueToSize/calculation/{shoe_id}")
    public TrueToSizeCalculation getTrueToSizeCalculation(@PathVariable(value = "shoe_id") final Long shoeId) {
        log.info("Starting GET /trueToSize/calculation/{shoe_id} for shoe_id: {}", shoeId);
        final TrueToSizeCalculation trueToSizeCalculation = trueToSizeService.computeTrueToSizeCalculation(shoeId);
        log.info("Finishing GET /trueToSize/calculation/{shoe_id} for shoe_id: {}", shoeId);
        return trueToSizeCalculation;
    }

}
