package com.example.bortakvall.Controllers;


import com.example.bortakvall.entity.Customer;
import com.example.bortakvall.entity.Movie;
import com.example.bortakvall.Repositories.CustomerRepository;
import com.example.bortakvall.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;


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

    @GetMapping("/home")
    public String home(){

        return "index";
    }


    @PostMapping("/rentmovie")
    public String rentMovie(@RequestParam String productid, String socialsecuritynumber){
        Movie movie = movieRepository.getOne(productid);
        Customer customer = customerRepository.getOne(socialsecuritynumber);
        movie.setCustomer(customer);
        movieRepository.save(movie);
        return "redirect:/movies";
    }


    @PostMapping("/movies")
    public String addMovie(@RequestParam String productid, String name, String format, String description, Date releasedate){
        Movie movie = new Movie();
        movie.setName(name);
        movie.setDescription(description);
        movie.setFormat(format);
        movie.setReleasedate(releasedate);
        movie.setProductid(productid);
        movieRepository.save(movie);
        return "redirect:/movies";

    }
}