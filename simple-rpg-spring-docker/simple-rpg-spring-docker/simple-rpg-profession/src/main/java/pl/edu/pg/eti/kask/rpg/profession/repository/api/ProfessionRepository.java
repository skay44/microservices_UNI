package pl.edu.pg.eti.kask.rpg.profession.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pg.eti.kask.rpg.profession.entity.Profession;

import java.util.UUID;

/**
 * Repository for profession entity. Repositories should be used in business layer (e.g.: in services).
 */
@Repository
public interface ProfessionRepository extends JpaRepository<Profession, UUID> {

}
