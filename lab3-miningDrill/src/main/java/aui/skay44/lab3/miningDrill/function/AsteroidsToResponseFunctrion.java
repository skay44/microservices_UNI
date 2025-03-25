package aui.skay44.lab3.miningDrill.function;

import aui.skay44.lab3.dto.GetAsteroidResponse;
import aui.skay44.lab3.dto.GetAsteroidsResponse;
import org.springframework.stereotype.Component;
import aui.skay44.lab3.Asteroid;

import java.util.List;
import java.util.function.Function;

@Component
public class AsteroidsToResponseFunctrion implements Function<List<Asteroid>, GetAsteroidsResponse> {
    @Override
    public GetAsteroidsResponse apply(List<Asteroid> entities) {
        return GetAsteroidsResponse.builder()
                .asteroids(entities.stream()
                        .map(profession -> GetAsteroidsResponse.Asteroid.builder()
                                .id(profession.getId())
                                .build())
                        .toList())
                .build();
    }
}
