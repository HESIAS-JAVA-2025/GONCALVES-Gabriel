package org.hesias.services;

import org.hesias.entities.Garage;
import org.hesias.repositories.GarageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarageService implements IGarageService {

    private GarageRepository garageRepository;

    public GarageService(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    @Override
    public List<Garage> getAllGarage() {
        return garageRepository.findAll();
    }

    @Override
    public void addGarage(Garage garage) {
        garageRepository.save(garage);
    }


    public void updateGarage(Garage garage) {
        garageRepository.save(garage);
    }
}
