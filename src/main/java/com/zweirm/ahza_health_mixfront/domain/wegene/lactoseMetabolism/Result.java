package com.zweirm.ahza_health_mixfront.domain.wegene.lactoseMetabolism;

import java.util.List;

public class Result {
    private List<String> summary ;
    private List<String> summary_en ;
    private List<Advise> advise ;
    private List<Advise_en> advise_en ;
    private List<Genotypes> genotypes ;
    private int mag;
    private int odds;

    public List<String> getSummary() {
        return summary;
    }

    public void setSummary(List<String> summary) {
        this.summary = summary;
    }

    public List<String> getSummary_en() {
        return summary_en;
    }

    public void setSummary_en(List<String> summary_en) {
        this.summary_en = summary_en;
    }

    public List<Advise> getAdvise() {
        return advise;
    }

    public void setAdvise(List<Advise> advise) {
        this.advise = advise;
    }

    public List<Advise_en> getAdvise_en() {
        return advise_en;
    }

    public void setAdvise_en(List<Advise_en> advise_en) {
        this.advise_en = advise_en;
    }

    public List<Genotypes> getGenotypes() {
        return genotypes;
    }

    public void setGenotypes(List<Genotypes> genotypes) {
        this.genotypes = genotypes;
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
}
