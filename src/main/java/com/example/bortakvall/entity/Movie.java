package com.example.bortakvall.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;


@Entity
public class Movie {


    @Id
    private String productid;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private Date releasedate;

    @NotNull
    private String format;


    private Boolean returned;

    @ManyToOne
    @JoinColumn(name = "customer_socialsecuritynumber")
    private Customer customer;

    public Movie(){

    }


    public Movie(String productid, @NotNull String name, @NotNull String description, @NotNull Date releasedate, @NotNull String format) {
        this.productid = productid;
        this.name = name;
        this.description = description;
        this.releasedate = releasedate;
        this.format = format;
        this.returned = returned;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
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

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Boolean getReturned() {
        return returned;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }
}
