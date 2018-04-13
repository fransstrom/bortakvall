package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {


    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    MovieRepository movieRepository;


    @GetMapping("/customer")
    public String showCustomers(Model model) {
        model.addAttribute("customer", customerRepository.findAll());
        return "customerindex";
    }

    @PostMapping("/updateinfo")
    public String addpet(@RequestParam String name, String address, String postalcode, String city,
                         String country, String phone, String email,
                         String socialsecuritynumber, Model model) {

        Customer customer = customerRepository.getOne(socialsecuritynumber);
        customer.setPostalcode(postalcode);
        customer.setEmail(email);
        customer.setName(name);
        customer.setCity(city);
        customer.setCountry(country);
        customer.setPhone(phone);
        customer.setAddress(address);
        customerRepository.save(customer);
        model.addAttribute("customer", customerRepository.findAll());

        return "redirect:/customer";
    }

    @PostMapping("/customer")
    public String addCustomer(@RequestParam String socialsecuritynumber, String name, String address,
                              String postalcode, String city, String country, String phone, String email) {
        Customer customer = new Customer();
        customer.setPhone(phone);
        customer.setCountry(country);
        customer.setCity(city);
        customer.setEmail(email);
        customer.setAddress(address);
        customer.setPostalcode(postalcode);
        customer.setName(name);
        customer.setSocialsecuritynumber(socialsecuritynumber);
        customerRepository.save(customer);
        return "redirect:/customer";
    }

}
