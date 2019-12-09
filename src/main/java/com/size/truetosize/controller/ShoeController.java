package com.size.truetosize.controller;

import com.size.truetosize.model.Shoe;
import com.size.truetosize.service.ShoeService;
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
public class ShoeController {

    private final ShoeService shoeService;

    @PostMapping("/shoe")
    public Shoe createShoe(@RequestBody final com.size.truetosize.model.Shoe shoe) {
        log.info("Starting POST /shoe");
        final Shoe savedShoe = shoeService.createShoe(shoe);
        log.info("Finishing POST /shoe");
        return savedShoe;
    }

    @GetMapping("/shoe")
    public List<Shoe> getAllShoes() {
        log.info("Starting GET /shoe");
        final List<Shoe> shoes = this.shoeService.findAll();
        log.info("Finishing GET /shoe");
        return shoes;
    }

    @GetMapping("/shoe/{shoe_id}")
    public Shoe getShoeById(@PathVariable(value = "shoe_id") final Long shoeId) {
        log.info("Starting GET /shoe/{shoe_id} for shoe_id: {}", shoeId);
        final Shoe shoe = shoeService.findShoeById(shoeId);
        log.info("Finishing GET /shoe/{shoe_id} for shoe_id: {}", shoeId);
        return shoe;
    }
}
