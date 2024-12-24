package tn.esprit.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.backend.entity.Temperature;

@Repository
public interface TemperatureRepository extends JpaRepository<Temperature, Long> {
}
