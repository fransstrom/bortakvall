package com.example.bortakvall.forms;

import com.example.bortakvall.entity.Customer;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

public class MovieForm {

    @Id
    private String productid;

    @NotNull
    @Size(min = 5, max = 200)
    private String name;

    @NotNull
    @Size(min = 5, max = 200)
    private String description;

    @NotNull
    private Date releasedate;

    @NotNull
    @Size(min = 2, max = 200)
    private String format;


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





}
