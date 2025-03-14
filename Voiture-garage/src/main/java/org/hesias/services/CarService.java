package org.hesias.services;

import org.hesias.entities.Car;
import org.hesias.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements ICarService {

    private CarRepository CarRepository;

    public CarService(CarRepository CarRepository) {
        this.CarRepository = CarRepository;
    
    }

    @Override
    public List<Car> getAllCars() {
        return CarRepository.findAll();
    }

    @Override
    public void addCar(Car Car) {
        CarRepository.save(Car);
    }

    @Override
    public List<Car> getCarsByMark(String Mark) {
        return CarRepository.findByMark(Mark);
    }

    @Override
    public void deleteCarById(int id) {
        CarRepository.deleteById(id);
    }

    @Override
    public Car getCarById(int id) {
        return CarRepository.findById(id).orElse(null);
    }

    @Override
    public Car updateCar(Car Car) {
        return CarRepository.save(Car);
    }

}
