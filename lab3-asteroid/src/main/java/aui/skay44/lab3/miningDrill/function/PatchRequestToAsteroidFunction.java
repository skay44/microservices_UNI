package aui.skay44.lab3.miningDrill.function;

import aui.skay44.lab3.Asteroid;
import aui.skay44.lab3.AsteroidService;
import aui.skay44.lab3.dto.PatchAsteroidRequest;
import aui.skay44.lab3.dto.PutAsteroidRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class PatchRequestToAsteroidFunction implements BiFunction<Asteroid, PatchAsteroidRequest, Asteroid> {
    private final AsteroidService asteroidService;


    public PatchRequestToAsteroidFunction(AsteroidService asteroidService) {
        this.asteroidService = asteroidService;
    }

    @Override
    public Asteroid apply(Asteroid asteroid, PatchAsteroidRequest putAsteroidRequest) {
        return Asteroid.builder()
                .id(asteroid.getId())
                .name(putAsteroidRequest.getName())
                .size(putAsteroidRequest.getSize())
                .build();
    }
}