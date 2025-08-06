package org.animal_api.rest.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GrassDto extends PlantDto {

    private CowsDto cow;
    private GoatsDto goat;

}
