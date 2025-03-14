package org.hesias.services;

import org.hesias.entities.Garage;

import java.util.List;

public interface IGarageService {
    List<Garage> getAllGarage();

    void addGarage(Garage garage);

}
