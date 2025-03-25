package aui.skay44.lab3.controller.impl;

import aui.skay44.lab3.Asteroid;
import aui.skay44.lab3.dto.PutMiningDrillRequest;
import aui.skay44.lab3.service.impl.AsteroidService;
import aui.skay44.lab3.controller.api.AsteroidController;
import aui.skay44.lab3.dto.GetAsteroidResponse;
import aui.skay44.lab3.dto.GetAsteroidsResponse;
import aui.skay44.lab3.miningDrill.function.AsteroidToResponseFunction;
import aui.skay44.lab3.miningDrill.function.AsteroidsToResponseFunctrion;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class AsteroidDefaultController implements AsteroidController {

    private final AsteroidService service;

    @Autowired
    public AsteroidDefaultController(
            AsteroidService service
    ) {
        this.service = service;
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

    @Override
    public void putAsteroid(UUID id) {
        service.saveAsteroid(Asteroid.builder().id(id).build());
    }
}
