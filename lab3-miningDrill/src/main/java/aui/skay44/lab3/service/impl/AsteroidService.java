package aui.skay44.lab3.service.impl;

import aui.skay44.lab3.Asteroid;
import aui.skay44.lab3.repository.AsteroidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AsteroidService {

    private final AsteroidRepository asteroidRepository;

    @Autowired
    public AsteroidService(AsteroidRepository asteroidRepository) {
        this.asteroidRepository = asteroidRepository;
    }

    public Asteroid saveAsteroid(Asteroid asteroid) {
        return asteroidRepository.save(asteroid);
    }

    public Optional<Asteroid> getAsteroidById(UUID id) {
        return asteroidRepository.findById(id);
    }

    public void deleteAsteroid(UUID id) {
        asteroidRepository.deleteById(id);
    }
}
