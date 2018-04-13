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

import java.util.List;

@Controller
public class ReturnController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    MovieRepository movieRepository;


   /* @GetMapping("/rented")
    public String showCustomers(Model model){
        model.addAttribute("customer", customerRepository.findAllByMoviesIsNotNull());
        return "rentedindex";
    }
*/


   @GetMapping("/rented")
   public String showCustomers(Model model){
       model.addAttribute("customer", customerRepository.findAll());
       return "rentedindex";
   }


    @PostMapping("/rentedinfo")
    public String showMovies(Model model, @RequestParam String socialsecuritynumber){
        model.addAttribute("movie", movieRepository.findMovieByCustomerSocialsecuritynumber(socialsecuritynumber));
        return "redirect:/rented";

    }

    @PostMapping("/returnmovie")
    public String delete(@RequestParam String socialsecuritynumber){
        List<Movie> movies = movieRepository.findAllByCustomerSocialsecuritynumber(socialsecuritynumber);
        for (Movie movie : movies){
            movie.setCustomer(null);
            movieRepository.save(movie);
        }
        return "redirect:/rented";
    }





}
