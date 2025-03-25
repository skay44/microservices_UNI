package pl.edu.pg.eti.kask.rpg.profession.event.repository.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.edu.pg.eti.kask.rpg.profession.event.repository.api.ProfessionEventRepository;

import java.util.UUID;

@Repository
public class ProfessionEventRestRepository implements ProfessionEventRepository {

    /**
     * Configured rest template.
     */
    private final RestTemplate restTemplate;

    @Autowired
    public ProfessionEventRestRepository(RestTemplate template) {
        this.restTemplate = template;
    }

    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/professions/{id}", id);
    }

}
