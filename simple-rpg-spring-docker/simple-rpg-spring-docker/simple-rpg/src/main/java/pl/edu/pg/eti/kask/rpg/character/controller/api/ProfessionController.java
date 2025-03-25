package pl.edu.pg.eti.kask.rpg.character.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.edu.pg.eti.kask.rpg.character.dto.GetProfessionResponse;
import pl.edu.pg.eti.kask.rpg.character.dto.GetProfessionsResponse;

import java.util.UUID;

/**
 * Controller for profession resource. It does not return or receive entity objects but dto objects which present only
 * those fields which are used in communication with client.
 */
public interface ProfessionController {

    /**
     * @return list of professions
     */
    @GetMapping("api/professions")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetProfessionsResponse getProfessions();

    /**
     * @param id profession's id
     * @return single profession
     */
    @GetMapping("/api/professions/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetProfessionResponse getProfession(
            @PathVariable("id")
            UUID id
    );


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
