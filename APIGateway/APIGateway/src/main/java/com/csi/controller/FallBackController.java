package com.csi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class FallBackController {

    @GetMapping("/enquiryService")
     public String enquiryFallBack(){
        return  "Enquiry Service is down";
    }
    @GetMapping("/userService")
    public String userFallBack(){
        return  "User Service is down";
    }
    @GetMapping("/productService")
    public String productFallBack(){
        return  "Product Service is down";
    }
}
