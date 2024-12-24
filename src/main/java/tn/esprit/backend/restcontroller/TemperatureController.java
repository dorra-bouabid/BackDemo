package tn.esprit.backend.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.backend.entity.Temperature;
import tn.esprit.backend.repository.TemperatureRepository;
import tn.esprit.backend.service.TemperatureService;

import java.time.LocalDateTime;

@RestController


public class TemperatureController {
    @Autowired
    TemperatureService temperatureService;
    private final TemperatureRepository temperatureRepository;

    public TemperatureController(TemperatureRepository temperatureRepository) {
        this.temperatureRepository = temperatureRepository;
    }

    @GetMapping("/temperature")

    public ResponseEntity<?> TemperatureController() {

        //this.temperatureRepository = temperatureRepository;
        return ResponseEntity.ok(temperatureRepository.findAll());
    }



    @PostMapping("/save")
    public ResponseEntity<String> saveTemperature(@RequestBody Temperature temperature) {
        temperature.setTimestamp(LocalDateTime.now());  // Set the timestamp of the reading
        temperatureRepository.save(temperature);  // Save the temperature in the database
        return ResponseEntity.ok("Temperature saved successfully");
    }
}
