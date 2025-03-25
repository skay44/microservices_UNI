package pl.edu.pg.eti.kask.rpg.user.service.api;

import pl.edu.pg.eti.kask.rpg.user.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service layer for all business actions regarding user entity.
 */
public interface UserService {

    /**
     * @return all available users
     */
    List<User> findAll();

    /**
     * @param id user's id
     * @return container with user
     */
    Optional<User> find(UUID id);

    /**
     * @param login user's login
     * @return container with user
     */
    Optional<User> find(String login);

    /**
     * Stores new user in the storage.
     *
     * @param user new user
     */
    void create(User user);

    /**
     * Deletes existing user.
     *
     * @param id existing user's id to be deleted
     */
    void delete(UUID id);

}
