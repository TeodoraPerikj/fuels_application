package mk.ukim.finki.dians_lab2.service;

import mk.ukim.finki.dians_lab2.model.Street;

import java.util.Optional;

public interface StreetService {

    Optional<Street> findByName(String name);

    Optional<Street> findById(Long id);
}
