package pl.edu.pg.eti.kask.rpg.profession.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

/**
 * Controller for profession resource. It does not return or receive entity objects but dto objects which present only
 * those fields which are used in communication with client.
 */
public interface ProfessionController {

    /**
     * Deletes selected profession.
     *
     * @param id profession's id
     */
    @DeleteMapping("/api/professions/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteProfession(
            @PathVariable("id")
            UUID id
    );

}
