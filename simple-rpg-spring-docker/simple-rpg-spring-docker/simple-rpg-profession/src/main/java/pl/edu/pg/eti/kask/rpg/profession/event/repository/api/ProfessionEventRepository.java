package pl.edu.pg.eti.kask.rpg.profession.event.repository.api;

import java.util.UUID;

/**
 * Repository for sending events about professions.
 */
public interface ProfessionEventRepository {

    /**
     * Delete profession.
     *
     * @param id profession's id
     */
    void delete(UUID id);

}
