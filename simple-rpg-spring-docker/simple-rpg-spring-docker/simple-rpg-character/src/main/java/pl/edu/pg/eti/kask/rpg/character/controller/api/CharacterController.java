package pl.edu.pg.eti.kask.rpg.character.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import pl.edu.pg.eti.kask.rpg.character.dto.GetCharacterResponse;
import pl.edu.pg.eti.kask.rpg.character.dto.GetCharactersResponse;
import pl.edu.pg.eti.kask.rpg.character.dto.PutCharacterRequest;

import java.util.UUID;

/**
 * Controller for character resource. It does not return or receive entity objects but dto objects which present only
 * those fields which are used in communication with client.
 */
public interface CharacterController {

    /**
     * @return list of characters
     */
    @GetMapping("api/characters")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetCharactersResponse getCharacters();

    /**
     * @param userId characters' owner
     * @return list of characters
     */
    @GetMapping("/api/users/{userId}/characters")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetCharactersResponse getUserCharacters(
            @PathVariable("userId")
            UUID userId
    );

    /**
     * @param professionId characters' profession
     * @return list of characters
     */
    @GetMapping("/api/professions/{professionId}/characters")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetCharactersResponse getProfessionCharacters(
            @PathVariable("professionId")
            UUID professionId
    );

    /**
     * @param id character's id
     * @return single character
     */
    @GetMapping("/api/characters/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetCharacterResponse getCharacter(
            @PathVariable("id")
            UUID id
    );

    /**
     * @param userId      owner id
     * @param characterId character id
     * @return single character
     */
    @GetMapping("/api/users/{userId}/characters/{characterId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetCharacterResponse getUserCharacter(
            @PathVariable("userId")
            UUID userId,
            @PathVariable("characterId")
            UUID characterId
    );

    /**
     * @param id character's id
     * @return single character's portrait
     */
    @GetMapping(path = "/api/characters/{id}/portrait", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    byte[] getCharacterPortrait(
            @PathVariable("id")
            UUID id
    );

    /**
     * @param id      character's id
     * @param request new character
     */
    @PutMapping("/api/characters/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putCharacter(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutCharacterRequest request
    );

    /**
     * @param id      character's id
     * @param request new portrait
     */
    @PutMapping(path = "/api/characters/{id}/portrait", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    void putCharacterPortrait(
            @PathVariable("id")
            UUID id,
            @RequestParam("request")
            MultipartFile request
    );

    /**
     * Deletes selected character.
     *
     * @param id character's id
     */
    @DeleteMapping("/api/characters/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCharacter(
            @PathVariable("id")
            UUID id
    );

}
