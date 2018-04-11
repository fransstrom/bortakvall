package com.example.demo.controller;


import com.example.demo.entity.Customer;
import com.example.demo.entity.Movie;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Date;

@Controller
public class MovieController {


    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    MovieRepository movieRepository;


    @GetMapping("/movies")
    public String getMovies(Model model){
        model.addAttribute("movie", movieRepository.findAll());
        return "movieindex";
    }


    @PostMapping("/rentmovie")
    public String rentMovie(@RequestParam String productId, String personnummer){
        Movie movie = movieRepository.getOne(productId);
        Customer customer = customerRepository.getOne(personnummer);
        movie.setCustomer(customer);
        movieRepository.save(movie);
        return "redirect:/movies";
    }


    @PostMapping("/movies")
    public String addMovie(@RequestParam String productId, String name){
        Movie movie = new Movie();
        movie.setName(name);
        movie.setProductId(productId);
        movieRepository.save(movie);
        return "redirect:/movies";

    }


}
