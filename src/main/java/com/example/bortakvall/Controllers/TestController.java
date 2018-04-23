package com.example.bortakvall.Controllers;



import com.example.bortakvall.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class TestController {


    @Autowired
    MovieRepository movieRepository;


    @GetMapping("/findall")
    public String findall(Model model, @RequestParam (defaultValue = "0") int page ){
        model.addAttribute("movie", movieRepository.findAll(PageRequest.of(page, 5)));
        return "search";
    }

    @GetMapping("/findbyname")
    public String findbyyear(Model model, @RequestParam String name, @RequestParam (defaultValue = "0") int page){
        model.addAttribute("movie", movieRepository.findAllByNameContainingIgnoreCase(name, PageRequest.of(page,5)));
        return "search";
    }

}