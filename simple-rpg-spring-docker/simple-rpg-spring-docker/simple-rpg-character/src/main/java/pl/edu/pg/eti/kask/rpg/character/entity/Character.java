package pl.edu.pg.eti.kask.rpg.character.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import pl.edu.pg.eti.kask.rpg.creature.entity.Creature;
import pl.edu.pg.eti.kask.rpg.profession.entity.Profession;
import pl.edu.pg.eti.kask.rpg.user.entity.User;

/**
 * Entity for game character owned by the user. Represents characters basic stats (see {@link Creature}) as well as
 * profession and skills. Also contains link to user (see @link {@link User}) for the sake of database relationship.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "characters")
public class Character extends Creature {

    /**
     * Character's background story.
     */
    private String background;

    /**
     * Character's age.
     */
    private Integer age;

    /**
     * Character's profession (class).
     */
    @ManyToOne
    @JoinColumn(name = "profession")
    private Profession profession;

    /**
     * Owner of this character.
     */
    @ManyToOne
    @JoinColumn(name = "user_name")
    private User user;

    /**
     * Character's level.
     */
    private Integer level;

    /**
     * Character's total experience.
     */
    private Integer experience;

    /**
     * Creature's portrait. Images in database are stored as blobs (binary large objects).
     */
    @ToString.Exclude
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    private byte[] portrait;

}
