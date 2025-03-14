package org.hesias.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String Mark;

    private String Model;

    @ManyToOne(fetch = FetchType.LAZY)
    private Garage garage;

}
