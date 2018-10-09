package com.zweirm.ahza_health_mixfront.domain.wegene;

import java.util.List;

public class WegeneUser {
    private Long id;
    private List<WegeneProfiles> profiles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<WegeneProfiles> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<WegeneProfiles> profiles) {
        this.profiles = profiles;
    }
}
