package pl.edu.pg.eti.kask.rpg.profession.initialize;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.pg.eti.kask.rpg.profession.entity.Profession;
import pl.edu.pg.eti.kask.rpg.profession.service.api.ProfessionService;

import java.util.UUID;

/**
 * Listener started automatically on Spring application context initialized. When using persistence storage application
 * instance should be initialized only during first run in order to init database with starting data. Good place to
 * create first default admin user.
 */
@Component
public class InitializeData implements InitializingBean {

    /**
     * Service for professions operations.
     */
    private final ProfessionService professionService;

    /**
     * @param professionService service for managing professions
     */
    @Autowired
    public InitializeData(ProfessionService professionService) {
        this.professionService = professionService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (professionService.findAll().isEmpty()) {
            Profession bard = Profession.builder()
                    .id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76"))
                    .name("Bard")
                    .build();

            Profession cleric = Profession.builder()
                    .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d4"))
                    .name("Cleric")
                    .build();

            Profession warrior = Profession.builder()
                    .id(UUID.fromString("2d9b1e8c-67c5-4188-a911-5f064a63d8cd"))
                    .name("Warrior")
                    .build();

            Profession rogue = Profession.builder()
                    .name("Rogue")
                    .id(UUID.randomUUID())
                    .build();

            professionService.create(bard);
            professionService.create(cleric);
            professionService.create(warrior);
            professionService.create(rogue);
        }
    }

}
