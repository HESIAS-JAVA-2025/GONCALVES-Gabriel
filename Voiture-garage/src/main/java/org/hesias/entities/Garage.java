package org.hesias.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Garage")
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "Garage_id")
    private List<Car> Cars = new ArrayList<>();

    public String getName() {
        return name;
    }

    public Garage setName(String name) {
        this.name = name;
        return this;
    }

    public int getId() {
        return id;
    }

    public Garage setId(int id) {
        this.id = id;
        return this;
    }

    public void addCar(Car Car) {
        Cars.add(Car);
    }

    public List<Car> getCars() {
        return Cars;
    }
}
