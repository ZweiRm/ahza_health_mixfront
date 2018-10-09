package com.zweirm.ahza_health_mixfront.domain.wegene.athletigen;

import java.util.List;

public class WegeneAthletigen {
    private String description;
    private String score;
    private String rank;
    private String caseid;
    private List<Genotypes> genotypes;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getCaseid() {
        return caseid;
    }

    public void setCaseid(String caseid) {
        this.caseid = caseid;
    }

    public List<Genotypes> getGenotypes() {
        return genotypes;
    }

    public void setGenotypes(List<Genotypes> genotypes) {
        this.genotypes = genotypes;
    }
}
