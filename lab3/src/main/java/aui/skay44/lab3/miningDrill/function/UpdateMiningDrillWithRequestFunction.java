package aui.skay44.lab3.miningDrill.function;

import aui.skay44.lab3.Asteroid;
import aui.skay44.lab3.AsteroidService;
import aui.skay44.lab3.dto.PatchMiningDrillRequest;
import aui.skay44.lab3.miningDrill.MiningDrill;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class UpdateMiningDrillWithRequestFunction implements BiFunction<MiningDrill, PatchMiningDrillRequest, MiningDrill> {
    private final AsteroidService asteroidService;

    public UpdateMiningDrillWithRequestFunction(AsteroidService asteroidService) {
        this.asteroidService = asteroidService;
    }

    @Override
    public MiningDrill apply(MiningDrill entity, PatchMiningDrillRequest request) {
        return MiningDrill.builder()
                .id(entity.getId())
                .name(request.getN())
                .drillSize(entity.getDrillSize())
                .asteroid(asteroidService.getAsteroidById(request.getA()).get()
                )
                .build();
    }
}
