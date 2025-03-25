package aui.skay44.lab3.miningDrill;

import aui.skay44.lab3.Asteroid;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "asteroid")
@Entity
@Table(name = "mining_drills")
public class MiningDrill implements Comparable<MiningDrill>, Serializable {
    @Id
    UUID id = UUID.randomUUID();
    @Column
    String name;
    @Column
    Integer drillSize;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "is_drilled_by")
    Asteroid asteroid;

    @Column
    UUID asteroidID;

    @Override
    public boolean equals(Object o) {
        if (this.hashCode() == o.hashCode()) return true;

        if (this.getClass() != o.getClass()) return false;
        if (this.compareTo((MiningDrill) o) == 0) return true;
        else return false;
    }

    @Override
    public int compareTo(MiningDrill o) { //1 -  wieksze niz o
        int comparison = this.name.compareTo(o.name);
        if(comparison == 0){
            return this.drillSize.compareTo(o.drillSize);
        }
        else return comparison;
    }
}
