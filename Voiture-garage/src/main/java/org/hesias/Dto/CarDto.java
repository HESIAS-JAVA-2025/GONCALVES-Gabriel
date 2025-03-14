package org.hesias.Dto;

import lombok.*;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class CarDto {
    private int id;
    private String title;
    private String author;
}
