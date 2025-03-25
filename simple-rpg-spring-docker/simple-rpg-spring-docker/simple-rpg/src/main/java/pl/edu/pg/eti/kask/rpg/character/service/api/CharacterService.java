package pl.edu.pg.eti.kask.rpg.character.service.api;

import pl.edu.pg.eti.kask.rpg.character.entity.Character;
import pl.edu.pg.eti.kask.rpg.user.entity.User;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service layer for all business actions regarding character entity.
 */

public interface CharacterService {

    /**
     * Finds single character.
     *
     * @param id character's id
     * @return container with character
     */
    Optional<Character> find(UUID id);

    /**
     * @param id   character's id
     * @param user existing user
     * @return selected character for user
     */
    Optional<Character> find(User user, UUID id);

    /**
     * @return all available characters
     */
    List<Character> findAll();

    /**
     * @param user existing user, character's owner
     * @return all available characters of the selected user
     */
    List<Character> findAll(User user);

    /**
     * Creates new character.
     *
     * @param character new character
     */
    void create(Character character);

    /**
     * Updates existing character.
     *
     * @param character character to be updated
     */
    void update(Character character);

    /**
     * Deletes existing character.
     *
     * @param id existing character's id to be deleted
     */
    void delete(UUID id);

    /**
     * @param id character's id
     * @return portrait bytes
     */
    Optional<byte[]> findPortrait(UUID id);

    /**
     * Updates portrait of the character.
     *
     * @param id character's id
     * @param is input stream containing new portrait
     */
    void updatePortrait(UUID id, InputStream is);

    /**
     * @param userId user id
     * @return list of characters is user exists
     */
    Optional<List<Character>> findAllByUser(UUID userId);

    /**
     * @param professionId profession id
     * @return list of characters if profession exists
     */
    Optional<List<Character>> findAllByProfession(UUID professionId);

}
