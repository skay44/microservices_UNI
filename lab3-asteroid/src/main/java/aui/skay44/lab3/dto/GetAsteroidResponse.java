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
public class GetAsteroidResponse {

    private UUID id;
    private  String name;
    private Integer asteroidSize;

}
