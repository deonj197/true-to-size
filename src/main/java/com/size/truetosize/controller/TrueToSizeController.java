package com.size.truetosize.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrueToSizeController {

    @GetMapping("/")
    public String test() {
        return "Service is up and running";
    }
}
