package aui.skay44.lab3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AsteroidRepository extends JpaRepository<Asteroid, UUID> {
    Optional<Asteroid> findByName(String name);
    Optional<Asteroid> findBySize(int size); //TODO moze usunac
}
