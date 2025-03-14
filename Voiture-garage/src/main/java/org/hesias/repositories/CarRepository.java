package org.hesias.repositories;

import org.hesias.entities.Car;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends ListCrudRepository<Car, Integer> {
    List<Car> findByMark(String Mark);
}
