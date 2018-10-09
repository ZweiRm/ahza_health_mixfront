package com.zweirm.ahza_health_mixfront.domain.wegene.lactoseMetabolism;

public class WegeneLactose {
    private String description;
    private String description_en;
    private int mag;
    private int odds;
    private String sex;
    private Result result;
    private int add_time;
    private int custom_update_time;
    private String category_child;
    private String rank;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription_en() {
        return description_en;
    }

    public void setDescription_en(String description_en) {
        this.description_en = description_en;
    }

    public int getMag() {
        return mag;
    }

    public void setMag(int mag) {
        this.mag = mag;
    }

    public int getOdds() {
        return odds;
    }

    public void setOdds(int odds) {
        this.odds = odds;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public int getAdd_time() {
        return add_time;
    }

    public void setAdd_time(int add_time) {
        this.add_time = add_time;
    }

    public int getCustom_update_time() {
        return custom_update_time;
    }

    public void setCustom_update_time(int custom_update_time) {
        this.custom_update_time = custom_update_time;
    }

    public String getCategory_child() {
        return category_child;
    }

    public void setCategory_child(String category_child) {
        this.category_child = category_child;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
