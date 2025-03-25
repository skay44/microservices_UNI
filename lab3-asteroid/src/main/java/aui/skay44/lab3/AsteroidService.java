package aui.skay44.lab3;

import aui.skay44.lab3.event.repository.rest.AsteroidEventRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AsteroidService {

    private final AsteroidRepository asteroidRepository;
    private final AsteroidEventRestRepository asteroidEventRestRepository;

    @Autowired
    public AsteroidService(AsteroidRepository asteroidRepository, AsteroidEventRestRepository asteroidEventRestRepository) {
        this.asteroidRepository = asteroidRepository;
        this.asteroidEventRestRepository = asteroidEventRestRepository;
    }

    public Asteroid saveAsteroid(Asteroid asteroid) {
        return asteroidRepository.save(asteroid);
    }

    public List<Asteroid> getAllAsteroids() {
        return asteroidRepository.findAll();
    }

    public Optional<Asteroid> getAsteroidById(UUID id) {
        return asteroidRepository.findById(id);
    }

    public Optional<Asteroid> findByName(String name) {
        return asteroidRepository.findByName(name);
    }

    public Optional<Asteroid> findBySize(int size) {
        return asteroidRepository.findBySize(size);
    }


    public void deleteAsteroid(UUID id) {
        asteroidRepository.deleteById(id);
        asteroidEventRestRepository.delete(id);
    }
}
