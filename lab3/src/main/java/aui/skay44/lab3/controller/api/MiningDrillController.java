package aui.skay44.lab3.controller.api;

import aui.skay44.lab3.dto.GetMiningDrillResponse;
import aui.skay44.lab3.dto.GetMiningDrillsResponse;
import aui.skay44.lab3.dto.PatchMiningDrillRequest;
import aui.skay44.lab3.dto.PutMiningDrillRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface MiningDrillController {

    @GetMapping("api/miningDrills")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMiningDrillsResponse getAllMiningDrills();

    @GetMapping("/api/asteroid/{asteroidID}/drills")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMiningDrillsResponse getAsteroidMiningDrills(
            @PathVariable("asteroidID")
            UUID asteroidID
    );

    @GetMapping("/api/miningDrill/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMiningDrillResponse getMiningDrill(
            @PathVariable("id")
            UUID id
    );

    @GetMapping("/api/asteroid/{asteroidID}/drills/{drillID}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMiningDrillsResponse getAsteroidMiningDrill(
            @PathVariable("asteroidID")
            UUID asteroidID,
            @PathVariable("drillID")
            UUID drillID
    );

    @PutMapping("/api/miningDrill/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putMiningDrill(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutMiningDrillRequest request
    );

    @DeleteMapping("/api/miningDrill/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteMiningDrill(
            @PathVariable("id")
            UUID id
    );

    @PatchMapping("/api/miningDrill/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void patchMiningDrill(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PatchMiningDrillRequest request
    );

    //TODO UPDATING???????
}
