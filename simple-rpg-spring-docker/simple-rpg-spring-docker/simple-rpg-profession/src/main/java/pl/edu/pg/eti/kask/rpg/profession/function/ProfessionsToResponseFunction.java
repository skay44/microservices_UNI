package pl.edu.pg.eti.kask.rpg.profession.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.eti.kask.rpg.profession.dto.GetProfessionsResponse;
import pl.edu.pg.eti.kask.rpg.profession.entity.Profession;

import java.util.List;
import java.util.function.Function;

/**
 * Converts {@link List<Profession>} to {@link GetProfessionsResponse}.
 */
@Component
public class ProfessionsToResponseFunction implements Function<List<Profession>, GetProfessionsResponse> {

    @Override
    public GetProfessionsResponse apply(List<Profession> entities) {
        return GetProfessionsResponse.builder()
                .professions(entities.stream()
                        .map(profession -> GetProfessionsResponse.Profession.builder()
                                .id(profession.getId())
                                .name(profession.getName())
                                .build())
                        .toList())
                .build();
    }

}
