package aui.skay44.lab3.miningDrill.function;

import aui.skay44.lab3.Asteroid;
import aui.skay44.lab3.AsteroidService;
import aui.skay44.lab3.dto.PutMiningDrillRequest;
import aui.skay44.lab3.miningDrill.MiningDrill;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToMiningDrillFunction implements BiFunction<UUID, PutMiningDrillRequest, MiningDrill> {
    private final AsteroidService asteroidService;

    public RequestToMiningDrillFunction(AsteroidService asteroidService) {
        this.asteroidService = asteroidService;
    }

    @Override
    public MiningDrill apply(UUID id, PutMiningDrillRequest request) {
        return MiningDrill.builder()
                .id(id)
                .name(request.getName())
                .drillSize(request.getSize())
                .asteroid(asteroidService.getAsteroidById(request.getAsteroid()).get()
                )
                .build();
    }
}
