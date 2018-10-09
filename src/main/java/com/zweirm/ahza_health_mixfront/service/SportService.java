package com.zweirm.ahza_health_mixfront.service;

import com.zweirm.ahza_health_mixfront.domain.Sport;
import com.zweirm.ahza_health_mixfront.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SportService {
    @Autowired
    private SportRepository sportRepository;

    public void saveSport(String username, Integer step, Integer energy, Integer floor, Integer stand) {
        Sport sport = new Sport();
        sport.setUsername(username);
        sport.setStep(step);
        sport.setEnergy(energy);
        sport.setFloor(floor);
        sport.setStand(stand);
        sport.setDate(new Date());

        sportRepository.save(sport);
    }

    public Sport findFirstByUsernameOrderByDateDesc(String username) {
        return sportRepository.findFirstByUsernameOrderByDateDesc(username);
    }
}
