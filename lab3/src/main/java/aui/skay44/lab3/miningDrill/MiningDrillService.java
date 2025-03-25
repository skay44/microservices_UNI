package aui.skay44.lab3.miningDrill;

import aui.skay44.lab3.Asteroid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MiningDrillService {

    private final MiningDrillRepository miningDrillRepository;

    @Autowired
    public MiningDrillService(MiningDrillRepository asteroidRepository) {
        this.miningDrillRepository = asteroidRepository;
    }

    public MiningDrill saveMiningDrill(MiningDrill asteroid) {
        return miningDrillRepository.save(asteroid);
    }

    public List<MiningDrill> getAllMiningDrills() {
        return miningDrillRepository.findAll();
    }

    public Optional<MiningDrill> getMiningDrillById(UUID id) {
        return miningDrillRepository.findById(id);
    }

    public Optional<MiningDrill> findByName(String name) {
        return miningDrillRepository.findByName(name);
    }

    public Optional<MiningDrill> findBySize(int size) {
        return miningDrillRepository.findByDrillSize(size);
    }

    public Optional<List<MiningDrill>> findByAsteroid(Asteroid asteroid) {
        return miningDrillRepository.findByAsteroid(asteroid);
    }

    public Optional<MiningDrill> findByID(UUID id) {return  miningDrillRepository.findById(id);} ;

    public Optional<List<MiningDrill>> findByAsteroidID(UUID asteroidID) {
        return miningDrillRepository.findByAsteroidID(asteroidID);
    }

    public void deleteMiningDrill(UUID id) {
        miningDrillRepository.deleteById(id);
    }
}
