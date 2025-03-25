package pl.edu.pg.eti.kask.rpg.user.controller.impl;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.pg.eti.kask.rpg.user.controller.api.UserController;
import pl.edu.pg.eti.kask.rpg.user.dto.GetUserResponse;
import pl.edu.pg.eti.kask.rpg.user.dto.GetUsersResponse;
import pl.edu.pg.eti.kask.rpg.user.entity.User;
import pl.edu.pg.eti.kask.rpg.user.function.UserToResponseFunction;
import pl.edu.pg.eti.kask.rpg.user.function.UsersToResponseFunction;
import pl.edu.pg.eti.kask.rpg.user.service.api.UserService;

import java.util.List;
import java.util.UUID;

/**
 * Controller for profession resource. It does not return or receive entity objects but dto objects which present only
 * those fields which are used in communication with client.
 */
@RestController
@Log
public class UserDefaultController implements UserController {

    /**
     * Service for managing professions.
     */
    private final UserService service;

    /**
     * Converts {@link User} to {@link GetUserResponse}.
     */
    private final UserToResponseFunction professionToResponse;

    /**
     * Coverts {@link List <User>} to {@link GetUsersResponse}.
     */
    private final UsersToResponseFunction professionsToResponse;

    /**
     * @param service               service for managing professions
     * @param professionToResponse  converts {@link User} to {@link GetUserResponse}
     * @param professionsToResponse coverts {@link List <User>} to {@link GetUsersResponse}
     */
    @Autowired
    public UserDefaultController(
            UserService service,
            UserToResponseFunction professionToResponse,
            UsersToResponseFunction professionsToResponse
    ) {
        this.service = service;
        this.professionToResponse = professionToResponse;
        this.professionsToResponse = professionsToResponse;
    }

    @Override
    public GetUsersResponse getUsers() {
        return professionsToResponse.apply(service.findAll());
    }

    @Override
    public GetUserResponse getUser(UUID id) {
        return service.find(id)
                .map(professionToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteUser(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        profession -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

}
