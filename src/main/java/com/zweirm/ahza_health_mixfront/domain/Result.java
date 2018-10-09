package com.zweirm.ahza_health_mixfront.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Result {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private Integer water;
    private Integer protein;
    private Integer fat;
    private Integer carbohydrate;
    private Integer step;
    private Integer energy;
    private Integer floor;
    private Integer stand;
    private Date date;

    public Result() {
    }

    public Result(String username, Integer water, Integer protein, Integer fat, Integer carbohydrate, Integer step, Integer energy, Integer floor, Integer stand, Date date) {
        this.username = username;
        this.water = water;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
        this.step = step;
        this.energy = energy;
        this.floor = floor;
        this.stand = stand;
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

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Integer getEnergy() {
        return energy;
    }

    public void setEnergy(Integer energy) {
        this.energy = energy;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getStand() {
        return stand;
    }

    public void setStand(Integer stand) {
        this.stand = stand;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
