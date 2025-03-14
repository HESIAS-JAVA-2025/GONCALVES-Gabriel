package org.hesias.services;

import org.hesias.entities.Car;

import java.util.List;

public interface ICarService {

    List<Car> getAllCars();

    void addCar(Car car);

    List<Car> getCarsByTitle(String title);

    void deleteCarById(int id);

    Car getCarById(int id);

    Car updateCar(Car car);

}
