package com.example.bortakvall.forms;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CustomerForm {

    @NotNull
    @Size(min = 5, max = 200)
    private String socialsecuritynumber;

    @NotNull
    @Size(min = 5, max = 200)
    private String name;

    @NotNull
    @Size(min = 5, max = 200)
    private String address;

    @NotNull
    @Size(min = 5, max = 200)
    private String postalcode;

    @NotNull
    @Size(min = 5, max = 200)
    private String city;

    @NotNull
    @Size(min = 5, max = 200)
    private String country;

    @NotNull
    @Size(min = 5, max = 200)
    private String phone;

    @NotNull
    @Size(min = 5, max = 200)
    private String email;

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


}
