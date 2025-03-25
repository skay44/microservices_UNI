package pl.edu.pg.eti.kask.rpg.profession.controller.impl;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.pg.eti.kask.rpg.profession.controller.api.ProfessionController;
import pl.edu.pg.eti.kask.rpg.profession.dto.GetProfessionResponse;
import pl.edu.pg.eti.kask.rpg.profession.dto.GetProfessionsResponse;
import pl.edu.pg.eti.kask.rpg.profession.entity.Profession;
import pl.edu.pg.eti.kask.rpg.profession.function.ProfessionToResponseFunction;
import pl.edu.pg.eti.kask.rpg.profession.function.ProfessionsToResponseFunction;
import pl.edu.pg.eti.kask.rpg.profession.service.api.ProfessionService;

import java.util.List;
import java.util.UUID;

/**
 * Controller for profession resource. It does not return or receive entity objects but dto objects which present only
 * those fields which are used in communication with client.
 */
@RestController
@Log
public class ProfessionDefaultController implements ProfessionController {

    /**
     * Service for managing professions.
     */
    private final ProfessionService service;

    /**
     * Converts {@link Profession} to {@link GetProfessionResponse}.
     */
    private final ProfessionToResponseFunction professionToResponse;

    /**
     * Coverts {@link List <Profession>} to {@link GetProfessionsResponse}.
     */
    private final ProfessionsToResponseFunction professionsToResponse;

    /**
     * @param service               service for managing professions
     * @param professionToResponse  converts {@link Profession} to {@link GetProfessionResponse}
     * @param professionsToResponse coverts {@link List <Profession>} to {@link GetProfessionsResponse}
     */
    @Autowired
    public ProfessionDefaultController(
            ProfessionService service,
            ProfessionToResponseFunction professionToResponse,
            ProfessionsToResponseFunction professionsToResponse
    ) {
        this.service = service;
        this.professionToResponse = professionToResponse;
        this.professionsToResponse = professionsToResponse;
    }

    @Override
    public GetProfessionsResponse getProfessions() {
        return professionsToResponse.apply(service.findAll());
    }

    @Override
    public GetProfessionResponse getProfession(UUID id) {
        return service.find(id)
                .map(professionToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteProfession(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        profession -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

}
