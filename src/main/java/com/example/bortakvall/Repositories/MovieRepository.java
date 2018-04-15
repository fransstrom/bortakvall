package com.example.bortakvall.Repositories;

import com.example.bortakvall.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, String> {

    List<Movie> findMovieByCustomerSocialsecuritynumber(String socialsecuritynumber);
    List<Movie> findAllByCustomerSocialsecuritynumber(String socialsecuritynumber);

}
