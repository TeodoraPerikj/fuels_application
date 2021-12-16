package mk.ukim.finki.dians_lab2.service;

import mk.ukim.finki.dians_lab2.model.Fuel;
import mk.ukim.finki.dians_lab2.model.Street;

import java.util.List;
import java.util.Optional;

public interface FuelService {

    Optional<Fuel> findByName(String name);

    List<Fuel> findAll();

    Optional<Fuel> findById(Long id);

    List<Fuel> findByStreet(Street street);

}
