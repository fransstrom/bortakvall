package com.example.bortakvall.Controllers;

import com.example.bortakvall.Repositories.CustomerRepository;
import com.example.bortakvall.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {


    @Autowired
    MovieRepository movieRepository;

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/search")

    public String movie(@RequestParam (value = "socialsecuritynumber", required = false, defaultValue = "999999") String socialsecuritynumber,
                        Model model){
        model.addAttribute("movie", movieRepository.findMovieByCustomerSocialsecuritynumber(socialsecuritynumber));
        return "searchrentedmovie";
    }



   /* @PostMapping("/returnmovie")
    public String delete(@RequestParam String socialsecuritynumber){
        List<Movie> movies = movieRepository.findAllByCustomerSocialsecuritynumber(socialsecuritynumber);
        for (Movie movie : movies){
            movie.setCustomer(null);
            movieRepository.save(movie);
        }
        return "redirect:/search";
    }*/

}

