package mk.ukim.finki.dians_lab2.service.impl;

import mk.ukim.finki.dians_lab2.model.Fuel;
import mk.ukim.finki.dians_lab2.model.Street;
import mk.ukim.finki.dians_lab2.model.exceptions.FuelByNameNotFoundException;
import mk.ukim.finki.dians_lab2.model.exceptions.FuelNotFoundException;
import mk.ukim.finki.dians_lab2.repository.jpa.FuelRepository;
import mk.ukim.finki.dians_lab2.service.FuelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuelServiceImpl implements FuelService {

    private final FuelRepository fuelRepository;

    public FuelServiceImpl(FuelRepository fuelRepository) {
        this.fuelRepository = fuelRepository;
    }

    @Override
    public Optional<Fuel> findByName(String name) {
        return Optional.of(this.fuelRepository.findByName(name).orElseThrow(()->new FuelByNameNotFoundException(name)));
    }

    @Override
    public List<Fuel> findAll() {
        return this.fuelRepository.findAll();
    }

    @Override
    public Optional<Fuel> findById(Long id) {
        return Optional.of(this.fuelRepository.findById(id).orElseThrow(()->new FuelNotFoundException(id)));
    }

    @Override
    public List<Fuel> findByStreet(Street street) {

        if(this.fuelRepository.findByStreet(street).isEmpty()){
            return null;
        }

       return this.fuelRepository.findByStreet(street);
    }

}
