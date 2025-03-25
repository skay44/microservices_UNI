package pl.edu.pg.eti.kask.rpg.initialize;

import lombok.SneakyThrows;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.pg.eti.kask.rpg.character.entity.Character;
import pl.edu.pg.eti.kask.rpg.character.entity.Profession;
import pl.edu.pg.eti.kask.rpg.character.service.api.CharacterService;
import pl.edu.pg.eti.kask.rpg.character.service.api.ProfessionService;
import pl.edu.pg.eti.kask.rpg.user.entity.User;
import pl.edu.pg.eti.kask.rpg.user.service.api.UserService;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Listener started automatically on Spring application context initialized. When using persistence storage application
 * instance should be initialized only during first run in order to init database with starting data. Good place to
 * create first default admin user.
 */
@Component
public class InitializeData implements InitializingBean {

    /**
     * Service for characters operations.
     */
    private final CharacterService characterService;

    /**
     * Service for users operations.
     */
    private final UserService userService;

    /**
     * Service for professions operations.
     */
    private final ProfessionService professionService;

    /**
     * @param characterService  service for managing characters
     * @param userService       service for managing users
     * @param professionService service for managing professions
     */
    @Autowired
    public InitializeData(
            CharacterService characterService,
            UserService userService,
            ProfessionService professionService
    ) {
        this.characterService = characterService;
        this.userService = userService;
        this.professionService = professionService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (userService.find("admin").isEmpty()) {
            User admin = User.builder()
                    .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a6"))
                    .login("admin")
                    .name("Adam")
                    .surname("Cormel")
                    .birthDate(LocalDate.of(1990, 10, 21))
                    .email("admin@simplerpg.example.com")
                    .password("adminadmin")
                    .build();

            User kevin = User.builder()
                    .id(UUID.fromString("81e1c2a9-7f57-439b-b53d-6db88b071e4e"))
                    .login("kevin")
                    .name("Kevin")
                    .surname("Pear")
                    .birthDate(LocalDate.of(2001, 1, 16))
                    .email("kevin@example.com")
                    .password("useruser")
                    .build();

            User alice = User.builder()
                    .id(UUID.fromString("ed6cfb2a-cad7-47dd-9b56-9d1e3c7a4197"))
                    .login("alice")
                    .name("Alice")
                    .surname("Grape")
                    .birthDate(LocalDate.of(2002, 3, 19))
                    .email("alice@example.com")
                    .password("useruser")
                    .build();

            userService.create(admin);
            userService.create(kevin);
            userService.create(alice);

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

            Character calvian = Character.builder()
                    .id(UUID.fromString("525d3e7b-bb1f-4c13-bf17-926d1a12e4c0"))
                    .name("Calvian")
                    .age(18)
                    .background("A yong bard with some infernal roots.")
                    .experience(0)
                    .level(1)
                    .profession(bard)
                    .charisma(16)
                    .constitution(12)
                    .strength(8)
                    .health(2 * 12)
                    .portrait(getResourceAsByteArray("../avatar/calvian.png"))//package relative path
                    .user(kevin)
                    .build();

            Character uhlbrecht = Character.builder()
                    .id(UUID.fromString("cc0b0577-bb6f-45b7-81d6-3db88e6ac19f"))
                    .name("Uhlbrecht")
                    .age(37)
                    .background("Quite experienced half-orc warrior.")
                    .experience(0)
                    .level(1)
                    .profession(warrior)
                    .charisma(8)
                    .constitution(10)
                    .strength(18)
                    .health(2 * 10)
                    .portrait(getResourceAsByteArray("../avatar/uhlbrecht.png"))//package relative path
                    .user(kevin)
                    .build();

            Character eloise = Character.builder()
                    .id(UUID.fromString("f08ef7e3-7f2a-4378-b1fb-2922d730c70d"))
                    .name("Eloise")
                    .age(32)
                    .background("Human cleric.")
                    .experience(0)
                    .level(1)
                    .profession(cleric)
                    .charisma(8)
                    .constitution(12)
                    .strength(14)
                    .health(2 * 12)
                    .portrait(getResourceAsByteArray("../avatar/eloise.png"))//package relative path
                    .user(alice)
                    .build();

            Character zereni = Character.builder()
                    .id(UUID.fromString("ff327e8a-77c0-4f9b-90a2-89e16895d1e1"))
                    .name("Zereni")
                    .age(20)
                    .background("Half elf rogue.")
                    .experience(0)
                    .level(1)
                    .profession(rogue)
                    .charisma(14)
                    .constitution(12)
                    .strength(10)
                    .health(2 * 12)
                    .portrait(getResourceAsByteArray("../avatar/zereni.png"))//package relative path
                    .user(alice)
                    .build();

            characterService.create(calvian);
            characterService.create(uhlbrecht);
            characterService.create(eloise);
            characterService.create(zereni);
        }
    }

    /**
     * @param name name of the desired resource
     * @return array of bytes read from the resource
     */
    @SneakyThrows
    private byte[] getResourceAsByteArray(String name) {
        try (InputStream is = this.getClass().getResourceAsStream(name)) {
            return is.readAllBytes();
        }
    }

}
