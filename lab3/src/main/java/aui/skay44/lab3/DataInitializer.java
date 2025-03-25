package aui.skay44.lab3;

import aui.skay44.lab3.miningDrill.MiningDrill;
import aui.skay44.lab3.miningDrill.MiningDrillService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataInitializer {
    private final AsteroidService asteroidService;
    private final MiningDrillService miningDrillService;

    @Autowired
    public DataInitializer(AsteroidService asteroidService, MiningDrillService miningDrillService) {
        this.asteroidService = asteroidService;
        this.miningDrillService = miningDrillService;
    }

    @PostConstruct
    public void constuct(){

        Asteroid[] asteroids = new Asteroid[3];

        asteroids[0] = Asteroid.builder().name("CHW-12").size(12).id(UUID.fromString("525d3e7b-bb1f-4c13-bf17-926d1a12e4c0")).build();
        asteroids[1] = Asteroid.builder().name("Promethiumite").size(15).id(UUID.fromString("3c6f1eb1-8069-44ab-988f-d7fed2b65d87")).build();
        asteroids[2] = Asteroid.builder().name("Broneis").size(11).id(UUID.fromString("81e1c2a9-7f57-439b-b53d-6db88b071e4e")).build();

        for (Asteroid a : asteroids) {
            asteroidService.saveAsteroid(a);
        }

        MiningDrill[] drills = new MiningDrill[6];

        drills[0] = MiningDrill.builder().name("BigusDrilus").drillSize(123).asteroid(asteroids[0]).id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a6")).build();
        drills[1] = MiningDrill.builder().name("RAM").drillSize(45).asteroid(asteroids[0]).id(UUID.fromString("84dfc3e6-99bd-4535-9452-54ccd7edf08e")).build();
        drills[2] = MiningDrill.builder().name("Destroyer1000").drillSize(23).asteroid(asteroids[1]).id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76")).build();
        drills[3] = MiningDrill.builder().name("RedBolt").drillSize(76).asteroid(asteroids[1]).id(UUID.fromString("ac4e2683-b2ba-4695-94d9-806a97fce71e")).build();
        drills[4] = MiningDrill.builder().name("Anihilator").drillSize(34).asteroid(asteroids[2]).id(UUID.fromString("3c6f1eb1-8069-44ab-988f-d7fed2b65d87")).build();
        drills[5] = MiningDrill.builder().name("XStoneCrusherX").drillSize(92).asteroid(asteroids[2]).id(UUID.fromString("3c6f45b1-8069-44ab-988f-d7fedab65d87")).build();

        for(MiningDrill d : drills){
            miningDrillService.saveMiningDrill(d);
        }
    }

}
