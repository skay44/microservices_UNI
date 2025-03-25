package pl.edu.pg.eti.kask.rpg.user.event.repository.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.edu.pg.eti.kask.rpg.user.event.repository.api.UserEventRepository;

import java.util.UUID;

@Repository
public class UserEventRestRepository implements UserEventRepository {

    /**
     * Configured rest template.
     */
    private final RestTemplate restTemplate;

    @Autowired
    public UserEventRestRepository(RestTemplate template) {
        this.restTemplate = template;
    }

    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/users/{id}", id);
    }

}
