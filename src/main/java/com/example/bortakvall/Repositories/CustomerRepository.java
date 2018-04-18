package com.example.bortakvall.Repositories;

import com.example.bortakvall.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    List<Customer> findAllBySocialsecuritynumber(String socialsecuritynumber);
    List<Customer> findAllByMoviesIsNotNull();
    List<Customer> findAllByMoviesGreaterThan(Integer amount);


}
