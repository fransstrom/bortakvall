package com.example.bortakvall.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

    @RequestMapping("/")
    public String errorPage(){
        throw new RuntimeException("Gick inte att hitta sidan");
    }
}
