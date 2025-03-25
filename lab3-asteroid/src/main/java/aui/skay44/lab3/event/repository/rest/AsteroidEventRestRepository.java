package aui.skay44.lab3.event.repository.rest;

import aui.skay44.lab3.event.repository.api.AsteroidEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class AsteroidEventRestRepository implements AsteroidEventRepository {
    /**
     * Configured rest template.
     */
    private final RestTemplate restTemplate;

    @Autowired
    public AsteroidEventRestRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/asteroid/{id}", id);
    }

    @Override
    public void put(UUID id) {
        restTemplate.put("/api/asteroid/{id}", id, id);
    }


}
