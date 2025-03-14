package org.hesias.controllers;

import org.hesias.Dto.CarDto;
import org.hesias.entities.Car;
import org.hesias.mappers.CarMapper;
import org.hesias.services.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Cars")
public class CarsController {

    private final CarService CarService;
    private final CarMapper CarMapper;

    public CarsController(CarService CarService, CarMapper CarMapper) {
        this.CarService = CarService;
        this.CarMapper = CarMapper;
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDto> update(@PathVariable int id, @RequestBody CarDto CarDto) {
        var Car = CarMapper.toEntity(CarDto);
        Car.setId(id);
        var CarUpdated = CarService.updateCar(Car);
        return ResponseEntity.ok(CarMapper.toDto(CarUpdated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CarDto> delete(@PathVariable int id) {
        CarService.deleteCarById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CarDto>> getAll() {
        var Cars = CarService.getAllCars().stream()
                .map(CarMapper::toDto)
                .collect(Collectors.toList());
        if(Cars.size() == 0)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(Cars);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getById(@PathVariable int id) {
        var Car = CarService.getCarById(id);
        if(Car == null) {
            return ResponseEntity.notFound().build();
        }
        var CarDto = CarMapper.toDto(Car);
        return ResponseEntity.ok(CarDto);
    }

    @PostMapping
    public ResponseEntity<CarDto> addCar(@RequestBody CarDto CarDto) {
        var Car = CarMapper.toEntity(CarDto);
        CarService.addCar(Car);
        var CarToReturn = CarMapper.toDto(Car);
        return ResponseEntity.created(URI.create("/Cars/" + CarToReturn.getId())).body(CarToReturn);
    }
}
