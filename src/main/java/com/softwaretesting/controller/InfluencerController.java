package com.softwaretesting.controller;

import com.softwaretesting.model.InfluencerModel;
import com.softwaretesting.model.request.RequestAddInfluencer;
import com.softwaretesting.service.InfluencerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class InfluencerController {

    @Autowired
    private InfluencerService influencerService;

    public InfluencerController(InfluencerService influencerService) {
        this.influencerService = influencerService;
    }

    @GetMapping("/about")
    public String about() {
        return "Influencer Application";
    }

    @PostMapping("/influencer")
    public ResponseEntity<?> recordInfluencer(@RequestBody @Valid RequestAddInfluencer influencer, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errorMessages = result.getFieldErrors().stream().map(error -> error.getField() + " : " + error.getDefaultMessage()).collect(Collectors.toList());
            System.out.println(errorMessages);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages.get(0));
        }
        InfluencerModel tempResult = influencerService.save(influencer);
        return ResponseEntity.status(HttpStatus.OK).body("New Influencer name : " + tempResult.getName() + " Added!");
    }

}
