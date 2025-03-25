package pl.edu.pg.eti.kask.rpg.profession.controller.impl;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.pg.eti.kask.rpg.profession.controller.api.ProfessionController;
import pl.edu.pg.eti.kask.rpg.profession.service.api.ProfessionService;

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
     * @param service service for managing professions
     */
    @Autowired
    public ProfessionDefaultController(ProfessionService service) {
        this.service = service;
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
