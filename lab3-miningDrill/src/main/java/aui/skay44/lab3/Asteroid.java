package aui.skay44.lab3;

import aui.skay44.lab3.miningDrill.MiningDrill;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "drills")
@Entity
@Table(name = "asteroids")
public class Asteroid implements Serializable {
    @Id
    UUID id = UUID.randomUUID();

    @OneToMany(mappedBy = "asteroid", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<MiningDrill> drills;

}
