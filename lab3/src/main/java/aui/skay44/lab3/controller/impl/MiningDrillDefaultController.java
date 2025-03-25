package aui.skay44.lab3.controller.impl;

import aui.skay44.lab3.AsteroidService;
import aui.skay44.lab3.controller.api.MiningDrillController;
import aui.skay44.lab3.dto.GetMiningDrillResponse;
import aui.skay44.lab3.dto.GetMiningDrillsResponse;
import aui.skay44.lab3.dto.PatchMiningDrillRequest;
import aui.skay44.lab3.dto.PutMiningDrillRequest;
import aui.skay44.lab3.miningDrill.MiningDrillService;
import aui.skay44.lab3.miningDrill.function.MiningDrillToResponseFunction;
import aui.skay44.lab3.miningDrill.function.MiningDrillsToResponseFunction;
import aui.skay44.lab3.miningDrill.function.RequestToMiningDrillFunction;
import aui.skay44.lab3.miningDrill.function.UpdateMiningDrillWithRequestFunction;
import jakarta.transaction.Transactional;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;

@RestController
@Log
public class MiningDrillDefaultController implements MiningDrillController {
    private final MiningDrillService service;

    private final MiningDrillToResponseFunction miningDrillToResponse;
    private final MiningDrillsToResponseFunction miningDrillsToResponse;
    private final RequestToMiningDrillFunction requestToMiningDrill;
    private final UpdateMiningDrillWithRequestFunction updateMiningDrillWithRequest;
    private final AsteroidService asteroidService;

    @Autowired
    public MiningDrillDefaultController(
            MiningDrillService service,
            MiningDrillToResponseFunction characterToResponse,
            MiningDrillsToResponseFunction charactersToResponse,
            RequestToMiningDrillFunction requestToCharacter,
            UpdateMiningDrillWithRequestFunction updateMiningDrillWithRequest,
            AsteroidService asteroidService) {
        this.service = service;
        this.miningDrillToResponse = characterToResponse;
        this.miningDrillsToResponse = charactersToResponse;
        this.requestToMiningDrill = requestToCharacter;
        this.updateMiningDrillWithRequest = updateMiningDrillWithRequest;
        this.asteroidService = asteroidService;
    }

    @Override
    public GetMiningDrillsResponse getAllMiningDrills() {
        return miningDrillsToResponse.apply(service.getAllMiningDrills());
    }

    @Override
    public GetMiningDrillsResponse getAsteroidMiningDrills(UUID asteroidID) {
        if(asteroidService.getAsteroidById(asteroidID).isPresent()) {
            return service.findByAsteroid(asteroidService.getAsteroidById(asteroidID).get()).map(miningDrillsToResponse).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND) );
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public GetMiningDrillResponse getMiningDrill(UUID id) {
        return service.findByID(id)
                .map(miningDrillToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetMiningDrillsResponse getAsteroidMiningDrill(UUID asteroidID, UUID drillID) {
        return null;
    }


    @Override
    @Transactional
    public void putMiningDrill(UUID id, PutMiningDrillRequest request) {
        service.saveMiningDrill(requestToMiningDrill.apply(id, request));
    }

    @Override
    public void deleteMiningDrill(UUID id) {
        service.findByID(id)
                .ifPresentOrElse(
                        miningDrill -> service.deleteMiningDrill(id),
                           () -> { throw new ResponseStatusException(HttpStatus.NOT_FOUND);} );
    }

    @Override
    public void patchMiningDrill(UUID id, PatchMiningDrillRequest request) {
        service.findByID(id).ifPresentOrElse(
                miningDrill -> {service.saveMiningDrill(updateMiningDrillWithRequest.apply(miningDrill,request));},
                () -> {throw new ResponseStatusException(HttpStatus.NOT_FOUND);}
        );

    }
}
