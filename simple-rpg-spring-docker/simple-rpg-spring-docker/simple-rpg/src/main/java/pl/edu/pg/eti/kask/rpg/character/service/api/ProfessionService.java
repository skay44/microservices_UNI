package pl.edu.pg.eti.kask.rpg.character.service.api;

import pl.edu.pg.eti.kask.rpg.character.entity.Profession;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service layer for all business actions regarding character's profession entity.
 */
public interface ProfessionService {


    /**
     * @param id id of the profession
     * @return container with profession entity
     */
    Optional<Profession> find(UUID id);

    /**
     * Stores new profession in the data store.
     *
     * @param profession new profession to be saved
     */
    void create(Profession profession);

    /**
     * @return all available professions
     */
    List<Profession> findAll();

    /**
     * Deletes existing profession.
     *
     * @param id existing profession's id to be deleted
     */
    void delete(UUID id);

}
