package com.example.demo.controller;


import com.example.demo.entity.Customer;
import com.example.demo.entity.Movie;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {


    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    MovieRepository movieRepository;

    private int pagesize = 5;


    @GetMapping("/pet")
    public String page(@RequestParam (required = false) Integer page, Model md ){
        md.addAttribute("customer",customerRepository.findAll(PageRequest.of(page != null ? page : 0, pagesize)));
        return "index";
    }
    @PostMapping("/pet")
    public String addOwner(@RequestParam String socialsecuritynumber, String name, String address,
                           String postalcode, String city, String country, String phone, String email){
        Customer customer = new Customer();
        customer.setSocialsecuritynumber(socialsecuritynumber);
        customer.setName(name);
        customer.setAddress(address);
        customer.setCity(city);
        customer.setCountry(country);
        customer.setEmail(email);
        customer.setPostalcode(postalcode);
        customer.setPhone(phone);
        customerRepository.save(customer);
        return "redirect:/pet";
    }


    @PostMapping("/deletecustomer")
    public String delete(@RequestParam String personnummer, Model model){
        customerRepository.deleteById(personnummer);
        model.addAttribute("customer", customerRepository.findAll());
        return "redirect:/pet";
    }

    @PostMapping("/updateinfo")
    public String addpet(@RequestParam String name, String address, String postalcode, String city,
                         String country, String phone, String email,
                         String personnummer, Model model){

        Customer customer = customerRepository.getOne(personnummer);
        customer.setPostalcode(postalcode);
        customer.setEmail(email);
        customer.setName(name);
        customer.setCity(city);
        customer.setCountry(country);
        customer.setPhone(phone);
        customer.setAddress(address);
        customerRepository.save(customer);
        model.addAttribute("customer", customerRepository.findAll());
        return "redirect:/pet";
    }


}
