package aui.skay44.lab3.dto;

import aui.skay44.lab3.miningDrill.MiningDrill;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchMiningDrillRequest {
    private String n;
    private UUID a;
}
