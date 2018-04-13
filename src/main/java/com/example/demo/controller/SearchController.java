package com.example.demo.controller;


import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {


    @Autowired
    MovieRepository movieRepository;

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/search")
    public String movie(@RequestParam (value = "personnummer", required = false) String personnummer, Model model){
        model.addAttribute("movie", movieRepository.findMovieByCustomerPersonnummer(personnummer));
        model.addAttribute("usermovies", customerRepository.findAll());
        return "searchmovie";
    }



}
