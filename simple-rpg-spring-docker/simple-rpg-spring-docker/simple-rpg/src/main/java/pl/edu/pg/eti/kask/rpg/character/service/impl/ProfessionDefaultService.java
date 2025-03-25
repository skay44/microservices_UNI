package pl.edu.pg.eti.kask.rpg.character.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.eti.kask.rpg.character.entity.Profession;
import pl.edu.pg.eti.kask.rpg.character.repository.api.ProfessionRepository;
import pl.edu.pg.eti.kask.rpg.character.service.api.ProfessionService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service layer for all business actions regarding character's profession entity.
 */
@Service
public class ProfessionDefaultService implements ProfessionService {

    /**
     * Repository for profession entity.
     */
    private final ProfessionRepository repository;

    /**
     * @param repository repository for profession entity
     */
    @Autowired
    public ProfessionDefaultService(ProfessionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Profession> findAll() {
        return repository.findAll();
    }

    /**
     * @param id id of the profession
     * @return container with profession entity
     */
    @Override
    public Optional<Profession> find(UUID id) {
        return repository.findById(id);
    }

    /**
     * Stores new profession in the data store.
     *
     * @param profession new profession to be saved
     */
    @Override
    public void create(Profession profession) {
        repository.save(profession);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }
}
