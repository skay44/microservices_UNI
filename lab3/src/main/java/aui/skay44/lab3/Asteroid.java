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
public class Asteroid implements Comparable<Asteroid>, Serializable {
    @Id
    UUID id = UUID.randomUUID();
    @Column
    String name;
    @Column
    Integer size;

    @OneToMany(mappedBy = "asteroid", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<MiningDrill> drills;

    @Override
    public boolean equals(Object o) {
        if (this.hashCode() == o.hashCode()) return true;

        if (this.getClass() != o.getClass()) return false;
        if (this.compareTo((Asteroid) o) == 0) return true;
        else return false;
    }

    @Override
    public int compareTo(Asteroid o) { //1 -  wieksze niz o
        int comparison = this.name.compareTo(o.name);
        if(comparison == 0){
            return this.size.compareTo(o.size);
        }
        else return comparison;
    }
}
