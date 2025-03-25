package aui.skay44.lab3.miningDrill;

import aui.skay44.lab3.Asteroid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MiningDrillRepository extends JpaRepository<MiningDrill, UUID> {
    Optional<MiningDrill> findByName(String name);
    Optional<MiningDrill> findByDrillSize(int drillSize);
    Optional<List<MiningDrill>> findByAsteroid(Asteroid asteroid);
    Optional<List<MiningDrill>> findByAsteroidID(UUID id);

}

