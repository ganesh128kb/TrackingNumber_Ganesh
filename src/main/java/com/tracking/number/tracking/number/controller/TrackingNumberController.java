package com.tracking.number.tracking.number.controller;

import com.tracking.number.tracking.number.service.TrackingNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TrackingNumberController {
    @Autowired
    private TrackingNumberService generatorService;

    @GetMapping("/generate")
    public String generateSingleTrackingNumber() {
        return generatorService.generateTrackingNumber();
    }

    @GetMapping("/generateMultiple")
    public List<String> generateMultipleTrackingNumbers(@RequestParam int count) {
        return generatorService.generateMultipleTrackingNumbers(count).collect(Collectors.toList());
    }
}