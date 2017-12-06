package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Autowired
    Bookservice bookservice;

    @GetMapping("/")
    public String root(){
        String message = bookservice.root();
        return message + " available";
    }
}
