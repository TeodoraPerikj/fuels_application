package mk.ukim.finki.dians_lab2.repository.jpa;

import mk.ukim.finki.dians_lab2.model.Fuel;
import mk.ukim.finki.dians_lab2.model.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StreetRepository extends JpaRepository<Street,Long> {

    Optional<Street> findByName(String name);

    Optional<Street> findById(Long id);
}
