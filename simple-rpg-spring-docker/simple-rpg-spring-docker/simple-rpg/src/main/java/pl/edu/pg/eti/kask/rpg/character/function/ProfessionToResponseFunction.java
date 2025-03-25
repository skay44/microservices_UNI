package pl.edu.pg.eti.kask.rpg.character.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.eti.kask.rpg.character.dto.GetProfessionResponse;
import pl.edu.pg.eti.kask.rpg.character.entity.Profession;

import java.util.function.Function;

/**
 * Converts {@link Profession} to {@link GetProfessionResponse}.
 */
@Component
public class ProfessionToResponseFunction implements Function<Profession, GetProfessionResponse> {

    @Override
    public GetProfessionResponse apply(Profession entity) {
        return GetProfessionResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

}
