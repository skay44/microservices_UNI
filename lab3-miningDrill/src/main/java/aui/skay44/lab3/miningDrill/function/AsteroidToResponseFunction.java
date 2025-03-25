package aui.skay44.lab3.miningDrill.function;

import aui.skay44.lab3.dto.GetAsteroidResponse;
import org.springframework.stereotype.Component;
import aui.skay44.lab3.Asteroid;

import java.util.function.Function;

@Component
public class AsteroidToResponseFunction implements Function<Asteroid, GetAsteroidResponse> {
    @Override
    public GetAsteroidResponse apply(Asteroid asteroid) {
        return GetAsteroidResponse.builder()
                .id(asteroid.getId())
                .build();
    }
}
