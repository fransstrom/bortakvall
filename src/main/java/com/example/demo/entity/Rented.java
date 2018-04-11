package com.example.demo.entity;


import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
public class Rented {

    private Long id;

    private Date rentdate;

    private Date returndate;

    private Movie movie;

    public Rented(){

    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRentdate() {
        return rentdate;
    }

    public void setRentdate(Date rentdate) {
        this.rentdate = rentdate;
    }

    public Date getReturndate() {
        return returndate;
    }

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    @OneToOne
    @JoinColumn(name = "productId")
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
