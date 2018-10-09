package com.zweirm.ahza_health_mixfront.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Food {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private Integer water;
    private Integer protein;
    private Integer fat;
    private Integer carbohydrate;
    private Date date;

    public Food() {
    }

    public Food(String username, Integer water, Integer fat, Integer carbohydrate, Date date) {
        this.username = username;
        this.water = water;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getWater() {
        return water;
    }

    public void setWater(Integer water) {
        this.water = water;
    }

    public Integer getProtein() {
        return protein;
    }

    public void setProtein(Integer protein) {
        this.protein = protein;
    }

    public Integer getFat() {
        return fat;
    }

    public void setFat(Integer fat) {
        this.fat = fat;
    }

    public Integer getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(Integer carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
