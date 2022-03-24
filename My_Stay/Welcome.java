package com.example.My_Stay;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Welcome {
@RequestMapping("/")
public String greet(){

    return "Welcome to My_Stay Your Home Away From Home";
    }

}
