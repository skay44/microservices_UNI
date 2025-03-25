package aui.skay44.lab3;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataInitializer {
    private final AsteroidService asteroidService;

    @Autowired
    public DataInitializer(AsteroidService asteroidService) {
        this.asteroidService = asteroidService;
    }

    @PostConstruct
    public void constuct(){

        Asteroid[] asteroids = new Asteroid[3];

        asteroids[0] = Asteroid.builder().name("CHW-12").size(12).id(UUID.fromString("525d3e7b-bb1f-4c13-bf17-926d1a12e4c0")).build();
        asteroids[1] = Asteroid.builder().name("Promethiumite").size(15).id(UUID.fromString("3c6f1eb1-8069-44ab-988f-d7fed2b65d87")).build();
        asteroids[2] = Asteroid.builder().name("Broneis").size(11).id(UUID.fromString("81e1c2a9-7f57-439b-b53d-6db88b071e4e")).build();

        for (Asteroid a : asteroids) {
            asteroidService.saveAsteroid(a);
        }
    }

}
