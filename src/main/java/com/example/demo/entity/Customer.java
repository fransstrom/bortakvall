package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Customer {

 /*   Name • Address • Postal code (zip code) • City • Country • Phone • Email • Social Security Number (Personnummer)*/



    @Id
    private String socialsecuritynumber;

    @NotNull
    private String name;

    @NotNull
    private String address;

    @NotNull
    private String postalcode;

    @NotNull
    private String city;

    @NotNull
    private String country;

    @NotNull
    private String phone;

    @NotNull
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private List<Movie> movies;

    public Customer(){

    }

    public Customer(@Size(min = 10, max = 10) String socialsecuritynumber, @NotNull @Size(min = 2, max = 20) String name, @NotNull @Size(min = 3, max = 60) String address, @NotNull @Size(min = 5, max = 5) String postalcode, @NotNull @Size(min = 2, max = 40) String city, @NotNull @Size(min = 2, max = 30) String country, @NotNull @Size(min = 5, max = 20) String phone, @NotNull @Size(min = 5, max = 60) String email) {
        this.socialsecuritynumber = socialsecuritynumber;
        this.name = name;
        this.address = address;
        this.postalcode = postalcode;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.email = email;
    }


    public String getSocialsecuritynumber() {
        return socialsecuritynumber;
    }

    public void setSocialsecuritynumber(String socialsecuritynumber) {
        this.socialsecuritynumber = socialsecuritynumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}

