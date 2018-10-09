package com.zweirm.ahza_health_mixfront.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Sport {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private Integer step;
    private Integer energy;
    private Integer floor;
    private Integer stand;
    private Date date;

    public Sport() {
    }

    public Sport(String username, Integer step, Integer energy, Integer floor, Integer stand, Date date) {
        this.username = username;
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
