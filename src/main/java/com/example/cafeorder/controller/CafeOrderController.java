package com.example.cafeorder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CafeOrderController {

    @GetMapping("/")
    public String home() {
        return "カフェへようこそ！";
    }
}