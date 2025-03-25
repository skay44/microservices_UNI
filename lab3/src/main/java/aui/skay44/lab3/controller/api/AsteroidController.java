package aui.skay44.lab3.controller.api;

import aui.skay44.lab3.dto.GetAsteroidResponse;
import aui.skay44.lab3.dto.GetAsteroidsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface AsteroidController {

    @GetMapping("api/asteroids")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetAsteroidsResponse getAsteroids();

    @GetMapping("/api/asteroid/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetAsteroidResponse getAsteroid(
            @PathVariable("id")
            UUID id
    );

    @DeleteMapping("/api/asteroid/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAsteroid(
            @PathVariable("id")
            UUID id
    );
}
