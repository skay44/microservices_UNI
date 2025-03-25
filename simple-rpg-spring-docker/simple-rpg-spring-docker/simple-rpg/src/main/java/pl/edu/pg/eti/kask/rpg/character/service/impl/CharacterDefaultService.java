package pl.edu.pg.eti.kask.rpg.character.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.eti.kask.rpg.character.entity.Character;
import pl.edu.pg.eti.kask.rpg.character.repository.api.CharacterRepository;
import pl.edu.pg.eti.kask.rpg.character.repository.api.ProfessionRepository;
import pl.edu.pg.eti.kask.rpg.character.service.api.CharacterService;
import pl.edu.pg.eti.kask.rpg.user.entity.User;
import pl.edu.pg.eti.kask.rpg.user.repository.api.UserRepository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service layer for all business actions regarding character entity.
 */
@Service
public class CharacterDefaultService implements CharacterService {

    /**
     * Repository for character entity.
     */
    private final CharacterRepository repository;

    /**
     * Repository for profession entity.
     */
    private final ProfessionRepository professionRepository;

    /**
     * Repository for user entity.
     */
    private final UserRepository userRepository;


    /**
     * @param repository           repository for character entity
     * @param professionRepository repository for profession entity
     * @param userRepository       repository for user entity
     */
    @Autowired
    public CharacterDefaultService(
            CharacterRepository repository,
            ProfessionRepository professionRepository,
            UserRepository userRepository
    ) {
        this.repository = repository;
        this.professionRepository = professionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Character> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Character> find(User user, UUID id) {
        return repository.findByIdAndUser(id, user);
    }


    @Override
    public List<Character> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Character> findAll(User user) {
        return repository.findAllByUser(user);
    }

    @Override
    public Optional<List<Character>> findAllByProfession(UUID professionId) {
        return professionRepository.findById(professionId)
                .map(repository::findAllByProfession);
    }

    @Override
    public Optional<List<Character>> findAllByUser(UUID userId) {
        return userRepository.findById(userId)
                .map(repository::findAllByUser);
    }

    @Override
    public void create(Character character) {
        repository.save(character);
    }

    @Override
    public void update(Character character) {
        repository.save(character);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    @Override
    public Optional<byte[]> findPortrait(UUID id) {
        return repository.findPortraitById(id);
    }

    @Override
    public void updatePortrait(UUID id, InputStream is) {
        repository.findById(id).ifPresent(character -> {
            try {
                character.setPortrait(is.readAllBytes());
                repository.save(character);
            } catch (IOException ex) {
                throw new IllegalStateException(ex);
            }
        });
    }

}
