package aui.skay44.lab3.controller.impl;

import aui.skay44.lab3.AsteroidService;
import aui.skay44.lab3.controller.api.AsteroidController;
import aui.skay44.lab3.dto.GetAsteroidResponse;
import aui.skay44.lab3.dto.GetAsteroidsResponse;
import aui.skay44.lab3.dto.PatchAsteroidRequest;
import aui.skay44.lab3.dto.PutAsteroidRequest;
import aui.skay44.lab3.event.repository.rest.AsteroidEventRestRepository;
import aui.skay44.lab3.miningDrill.function.AsteroidToResponseFunction;
import aui.skay44.lab3.miningDrill.function.AsteroidsToResponseFunctrion;
import aui.skay44.lab3.miningDrill.function.PatchRequestToAsteroidFunction;
import aui.skay44.lab3.miningDrill.function.PutRequestToAsteroidFunction;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class AsteroidDefaultController implements AsteroidController {

    private final AsteroidService service;


    private final AsteroidToResponseFunction asteroidToResponse;


    private final AsteroidsToResponseFunctrion asteroidsToResponse;

    private final PutRequestToAsteroidFunction requestToAsteroid;
    private final PatchRequestToAsteroidFunction patchRequestToAsteroid;
    private final AsteroidEventRestRepository eventRestRepository;


    @Autowired
    public AsteroidDefaultController(
            AsteroidService service,
            AsteroidToResponseFunction asteroidToResponse,
            AsteroidsToResponseFunctrion asteroidsToResponse, PutRequestToAsteroidFunction requestToAsteroid, PatchRequestToAsteroidFunction patchRequestToAsteroid, AsteroidEventRestRepository eventRestRepository
    ) {
        this.service = service;
        this.asteroidToResponse = asteroidToResponse;
        this.asteroidsToResponse = asteroidsToResponse;
        this.requestToAsteroid = requestToAsteroid;
        this.patchRequestToAsteroid = patchRequestToAsteroid;
        this.eventRestRepository = eventRestRepository;
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

    @Override
    public void putAsteroid(UUID id, PutAsteroidRequest request) {
        service.saveAsteroid(requestToAsteroid.apply(id, request));
        eventRestRepository.put(id);
    }

    @Override
    public void patchAsteroid(UUID id, PatchAsteroidRequest request) {
        service.getAsteroidById(id).ifPresentOrElse(
                asteroid -> {service.saveAsteroid(patchRequestToAsteroid.apply(asteroid,request));},
                () -> {throw new ResponseStatusException(HttpStatus.NOT_FOUND);}
        );
    }
}
