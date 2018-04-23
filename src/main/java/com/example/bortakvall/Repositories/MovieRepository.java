package com.example.bortakvall.Repositories;

import com.example.bortakvall.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {

    List<Movie> findMovieByCustomerSocialsecuritynumber(String socialsecuritynumber);
    List<Movie> findAllByCustomerSocialsecuritynumber(String socialsecuritynumber);

    Page<Movie> findAllByNameContainingIgnoreCase(String name, Pageable pageable);
}
