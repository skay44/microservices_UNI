package pl.edu.pg.eti.kask.rpg.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.eti.kask.rpg.user.entity.User;
import pl.edu.pg.eti.kask.rpg.user.event.repository.api.UserEventRepository;
import pl.edu.pg.eti.kask.rpg.user.repository.api.UserRepository;
import pl.edu.pg.eti.kask.rpg.user.service.api.UserService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service layer for all business actions regarding user entity.
 */
@Service
public class UserDefaultService implements UserService {

    /**
     * Mock of the database. Should be replaced with repository layer.
     */
    private final UserRepository repository;

    /**
     * Repository for sending events about users management.
     */
    private final UserEventRepository eventRepository;

    @Autowired
    public UserDefaultService(UserRepository repository, UserEventRepository eventRepository) {
        this.repository = repository;
        this.eventRepository = eventRepository;
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<User> find(String login) {
        return repository.findByLogin(login);
    }

    @Override
    public Optional<User> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void create(User user) {
        repository.save(user);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
        eventRepository.delete(id);
    }

}
