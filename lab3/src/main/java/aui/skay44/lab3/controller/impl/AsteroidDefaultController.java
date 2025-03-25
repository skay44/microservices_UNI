package aui.skay44.lab3.controller.impl;

import aui.skay44.lab3.AsteroidService;
import aui.skay44.lab3.controller.api.AsteroidController;
import aui.skay44.lab3.dto.GetAsteroidResponse;
import aui.skay44.lab3.dto.GetAsteroidsResponse;
import aui.skay44.lab3.miningDrill.function.AsteroidToResponseFunction;
import aui.skay44.lab3.miningDrill.function.AsteroidsToResponseFunctrion;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import aui.skay44.lab3.Asteroid;

import java.util.List;
import java.util.UUID;

@RestController
@Log
public class AsteroidDefaultController implements AsteroidController {

    private final AsteroidService service;


    private final AsteroidToResponseFunction asteroidToResponse;


    private final AsteroidsToResponseFunctrion asteroidsToResponse;


    @Autowired
    public AsteroidDefaultController(
            AsteroidService service,
            AsteroidToResponseFunction asteroidToResponse,
            AsteroidsToResponseFunctrion asteroidsToResponse
    ) {
        this.service = service;
        this.asteroidToResponse = asteroidToResponse;
        this.asteroidsToResponse = asteroidsToResponse;
    }


    @Override
    public GetAsteroidsResponse getAsteroids() {
        return asteroidsToResponse.apply(service.getAllAsteroids());
    }

    @Override
    public GetAsteroidResponse getAsteroid(UUID id) {
        return service.getAsteroidById(id)
                .map(asteroidToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteAsteroid(UUID id) {
        service.getAsteroidById(id)
                .ifPresentOrElse(
                        profession -> service.deleteAsteroid(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}
