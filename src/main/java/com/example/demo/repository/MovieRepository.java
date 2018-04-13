package com.example.demo.repository;

import com.example.demo.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, String> {

    List<Movie> findMovieByCustomerSocialsecuritynumber(String socialsecuritynumber);
    List<Movie> findAllByCustomerSocialsecuritynumber(String socialsecuritynumber);

}
