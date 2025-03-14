package org.hesias.mappers;

import org.hesias.Dto.CarDto;
import org.hesias.entities.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarDto toDto(Car car);

    Car toEntity(CarDto Car);
}
