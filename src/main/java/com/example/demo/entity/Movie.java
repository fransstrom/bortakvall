package com.example.demo.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Movie {

    private String productId;

    private String name;

    private String description;

    private Date releasedate;

    private String category;

    private String format;

    private Customer customer;

    private Rented rented;

   public Movie(){

   }

    public Movie(String productId, String name, String description, Date releasedate, String category, String format) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.releasedate = releasedate;
        this.category = category;
        this.format = format;
    }


    @Id
    @Column(name = "product_id")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }


    @ManyToOne
    @JoinColumn(name = "person_nummer")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @OneToOne(mappedBy = "movie")
    public Rented getRented() {
        return rented;
    }

    public void setRented(Rented rented) {
        this.rented = rented;
    }


}
