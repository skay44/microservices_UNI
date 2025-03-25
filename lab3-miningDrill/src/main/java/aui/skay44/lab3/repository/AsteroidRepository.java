package aui.skay44.lab3.repository;

import aui.skay44.lab3.Asteroid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AsteroidRepository extends JpaRepository<Asteroid, UUID> {
}
