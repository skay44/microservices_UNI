package aui.skay44.lab3.miningDrill.function;

import aui.skay44.lab3.Asteroid;
import aui.skay44.lab3.AsteroidService;
import aui.skay44.lab3.dto.PutAsteroidRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class PutRequestToAsteroidFunction implements BiFunction<UUID, PutAsteroidRequest, Asteroid> {
    private final AsteroidService asteroidService;

    public PutRequestToAsteroidFunction(AsteroidService asteroidService) {
        this.asteroidService = asteroidService;
    }

    @Override
    public Asteroid apply(UUID uuid, PutAsteroidRequest putAsteroidRequest) {
        return Asteroid.builder()
                .id(uuid)
                .name(putAsteroidRequest.getName())
                .size(putAsteroidRequest.getSize())
                .build();
    }
}