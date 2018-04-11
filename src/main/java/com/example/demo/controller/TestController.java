package com.example.demo.controller;

import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.RentedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @Autowired
    RentedRepository rentedRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    MovieRepository movieRepository;


    /*@GetMapping("/test")
    public String test(Model model){
        model.addAttribute("movie", movieRepository.findCustom());
        return "viewtest";
    }*/


}
