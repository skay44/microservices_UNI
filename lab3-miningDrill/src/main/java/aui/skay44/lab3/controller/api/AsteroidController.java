package aui.skay44.lab3.controller.api;

import aui.skay44.lab3.dto.GetAsteroidResponse;
import aui.skay44.lab3.dto.GetAsteroidsResponse;
import aui.skay44.lab3.dto.PutMiningDrillRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface AsteroidController {

    @DeleteMapping("/api/asteroid/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAsteroid(
            @PathVariable("id")
            UUID id
    );

    @PutMapping("/api/asteroid/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putAsteroid(
            @PathVariable("id")
            UUID id
    );
}
