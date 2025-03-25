package pl.edu.pg.eti.kask.rpg.user.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pg.eti.kask.rpg.user.entity.User;

import java.util.UUID;

/**
 * Repository for User entity. Repositories should be used in business layer (e.g.: in services).
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
