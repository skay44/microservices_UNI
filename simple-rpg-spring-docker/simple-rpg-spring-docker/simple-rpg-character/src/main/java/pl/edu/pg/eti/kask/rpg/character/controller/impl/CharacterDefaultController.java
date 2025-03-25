package pl.edu.pg.eti.kask.rpg.character.controller.impl;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.pg.eti.kask.rpg.character.controller.api.CharacterController;
import pl.edu.pg.eti.kask.rpg.character.dto.GetCharacterResponse;
import pl.edu.pg.eti.kask.rpg.character.dto.GetCharactersResponse;
import pl.edu.pg.eti.kask.rpg.character.dto.PutCharacterRequest;
import pl.edu.pg.eti.kask.rpg.character.entity.Character;
import pl.edu.pg.eti.kask.rpg.character.function.CharacterToResponseFunction;
import pl.edu.pg.eti.kask.rpg.character.function.CharactersToResponseFunction;
import pl.edu.pg.eti.kask.rpg.character.function.RequestToCharacterFunction;
import pl.edu.pg.eti.kask.rpg.character.service.api.CharacterService;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

/**
 * Controller for character resource. It does not return or receive entity objects but dto objects which present only
 * those fields which are used in communication with client.
 */
@RestController
@Log
public class CharacterDefaultController implements CharacterController {

    /**
     * Service for managing characters.
     */
    private final CharacterService service;

    /**
     * Converts {@link Character} to {@link GetCharacterResponse}.
     */
    private final CharacterToResponseFunction characterToResponse;

    /**
     * Coverts {@link List <Character>} to {@link GetCharactersResponse}.
     */
    private final CharactersToResponseFunction charactersToResponse;

    /**
     * Converts {@link PutCharacterRequest} to {@link Character}.
     */
    private final RequestToCharacterFunction requestToCharacter;

    /**
     * @param service              service for managing characters
     * @param characterToResponse  converts {@link Character} to {@link GetCharacterResponse}
     * @param charactersToResponse coverts {@link List <Character>} to {@link GetCharactersResponse}
     * @param requestToCharacter   converts {@link PutCharacterRequest} to {@link Character}
     */
    @Autowired
    public CharacterDefaultController(
            CharacterService service,
            CharacterToResponseFunction characterToResponse,
            CharactersToResponseFunction charactersToResponse,
            RequestToCharacterFunction requestToCharacter
    ) {
        this.service = service;
        this.characterToResponse = characterToResponse;
        this.charactersToResponse = charactersToResponse;
        this.requestToCharacter = requestToCharacter;
    }

    @Override
    public GetCharactersResponse getCharacters() {
        return charactersToResponse.apply(service.findAll());
    }

    @Override
    public GetCharactersResponse getUserCharacters(UUID userId) {
        return service.findAllByUser(userId)
                .map(charactersToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetCharactersResponse getProfessionCharacters(UUID professionId) {
        return service.findAllByProfession(professionId)
                .map(charactersToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetCharacterResponse getCharacter(UUID id) {
        return service.find(id)
                .map(characterToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetCharacterResponse getUserCharacter(UUID userId, UUID characterId) {
        return null;
    }

    @Override
    public byte[] getCharacterPortrait(UUID id) {
        return service.find(id)
                .map(Character::getPortrait)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putCharacter(UUID id, PutCharacterRequest request) {
        service.create(requestToCharacter.apply(id, request));
    }

    @Override
    public void putCharacterPortrait(UUID id, MultipartFile request) {
        service.find(id)
                .ifPresentOrElse(
                        character -> {
                            try {
                                service.updatePortrait(id, request.getInputStream());
                            } catch (IOException ex) {
                                log.log(Level.WARNING, ex.getMessage(), ex);
                                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
                            }
                        },
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

    @Override
    public void deleteCharacter(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        character -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

}
