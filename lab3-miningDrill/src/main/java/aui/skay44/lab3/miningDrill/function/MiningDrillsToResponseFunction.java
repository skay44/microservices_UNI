package aui.skay44.lab3.miningDrill.function;

import aui.skay44.lab3.dto.GetMiningDrillsResponse;
import aui.skay44.lab3.miningDrill.MiningDrill;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class MiningDrillsToResponseFunction implements Function<List<MiningDrill>, GetMiningDrillsResponse> {

    @Override
    public GetMiningDrillsResponse apply(List<MiningDrill> miningDrills) {
        return GetMiningDrillsResponse.builder()
                .miningDrills(miningDrills.stream()
                        .map(character -> GetMiningDrillsResponse.MiningDrill.builder()
                                .id(character.getId())
                                .name(character.getName())
                                .build())
                        .toList())
                .build();
    }
}
