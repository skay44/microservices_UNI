package pl.edu.pg.eti.kask.rpg.character.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pg.eti.kask.rpg.character.entity.Character;
import pl.edu.pg.eti.kask.rpg.profession.entity.Profession;
import pl.edu.pg.eti.kask.rpg.user.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository for character entity. Repositories should be used in business layer (e.g.: in services).
 */
@Repository
public interface CharacterRepository extends JpaRepository<Character, UUID> {

    /**
     * Seeks for single user's character.
     *
     * @param id   character's id
     * @param user character's owner
     * @return container (can be empty) with character
     */
    Optional<Character> findByIdAndUser(UUID id, User user);

    /**
     * Seeks for all user's characters.
     *
     * @param user characters' owner
     * @return list (can be empty) of user's characters
     */
    List<Character> findAllByUser(User user);

    List<Character> findAllByProfession(Profession profession);

    /**
     * @param id character's id
     * @return portrait
     */
    Optional<byte[]> findPortraitById(UUID id);

}
