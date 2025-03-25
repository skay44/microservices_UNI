package pl.edu.pg.eti.kask.rpg.user.event.repository.api;

import java.util.UUID;

/**
 * Repository for sending events about users.
 */
public interface UserEventRepository {

    /**
     * Delete user.
     *
     * @param id user's id
     */
    void delete(UUID id);

}
