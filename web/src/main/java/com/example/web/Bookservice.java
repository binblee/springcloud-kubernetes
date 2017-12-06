package com.example.web;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("bookservice")
public interface Bookservice {

    @GetMapping("/")
    String root();
}
