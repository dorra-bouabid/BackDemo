package tn.esprit.backend.service;

import tn.esprit.backend.entity.Temperature;
import tn.esprit.backend.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TemperatureService {

    private final TemperatureRepository temperatureRepository;

    @Autowired
    public TemperatureService(TemperatureRepository temperatureRepository) {
        this.temperatureRepository = temperatureRepository;
    }

    public Temperature saveTemperature(Temperature temperature) {
        temperature.setTimestamp(LocalDateTime.now());
        return temperatureRepository.save(temperature);
    }
}
