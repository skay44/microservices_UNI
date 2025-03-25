package aui.skay44.lab3.miningDrill.function;

import aui.skay44.lab3.dto.GetMiningDrillResponse;
import aui.skay44.lab3.miningDrill.MiningDrill;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MiningDrillToResponseFunction implements Function<MiningDrill, GetMiningDrillResponse> {

    @Override
    public GetMiningDrillResponse apply(MiningDrill entity) {
        return GetMiningDrillResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .drillSize(entity.getDrillSize())
                .asteroid(GetMiningDrillResponse.Asteroid.builder()
                        .id(entity.getAsteroid().getId())
                        .build()
                )
                .build();
    }
}
