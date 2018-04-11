package com.example.demo.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {

 /*   Name • Address • Postal code (zip code) • City • Country • Phone • Email • Social Security Number (Personnummer)*/


    private String personnummer;

    private String namn;

    private String adress;

    private String zipcode;

    private String city;

    private String country;

    private String phone;

    private String email;

    private List<Movie> movies;

    public Customer(){

    }

    public Customer(String namn, String personnummer, String adress, String zipcode, String city, String country, String phone, String email) {
        this.namn = namn;
        this.personnummer = personnummer;
        this.adress = adress;
        this.zipcode = zipcode;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.email = email;
    }


    @Id
    @Column(name = "person_nummer")
    public String getPersonnummer() {
        return personnummer;
    }

    public void setPersonnummer(String personnummer) {
        this.personnummer = personnummer;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
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


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }
}
