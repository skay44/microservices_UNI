package aui.skay44.lab3.dto;

import lombok.*;

import java.util.UUID;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetMiningDrillResponse {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Asteroid {

        private UUID id;

        private String name;

        private Integer size;

    }

    private UUID id;
    private String name;
    private Integer drillSize;
    private Asteroid asteroid;

}
