package org.hesias.repositories;

import org.hesias.entities.Garage;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarageRepository extends ListCrudRepository<Garage, Integer> {
}
