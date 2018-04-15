package com.example.bortakvall.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class RentedInfo {

    @Id
    @GeneratedValue
    private Long id;

    private String socialsecuritynumber;

    private Date rentdate;

    private Date returndate;

    private String productid;

    public RentedInfo(){

    }

    public RentedInfo(String socialsecuritynumber, Date rentdate, Date returndate, String productid) {
        this.socialsecuritynumber = socialsecuritynumber;
        this.rentdate = rentdate;
        this.returndate = returndate;
        this.productid = productid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSocialsecuritynumber() {
        return socialsecuritynumber;
    }

    public void setSocialsecuritynumber(String socialsecuritynumber) {
        this.socialsecuritynumber = socialsecuritynumber;
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

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }
}
