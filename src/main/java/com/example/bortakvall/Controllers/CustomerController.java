package com.example.bortakvall.Controllers;

import com.example.bortakvall.entity.Customer;
import com.example.bortakvall.Repositories.CustomerRepository;
import com.example.bortakvall.Repositories.MovieRepository;
import com.example.bortakvall.forms.CustomerForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class CustomerController {


    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    MovieRepository movieRepository;


    @GetMapping("/customer")
    public String showCustomers(Model model, CustomerForm customerForm) {
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
    public String addCustomer(@Valid CustomerForm customerForm, BindingResult result, Model model) {
      if (result.hasErrors()){
          model.addAttribute("customer", customerRepository.findAll());
          System.out.println("gick in i error");
      return "customerindex";
      }else {
            customerRepository.save(new Customer(customerForm.getSocialsecuritynumber(),customerForm.getName(),customerForm.getAddress(),customerForm.getPostalcode(),customerForm.getCity(),customerForm.getCountry(),customerForm.getPhone(),customerForm.getEmail()));
          return "redirect:/customer";
      }
    }

}
