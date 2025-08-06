package org.animal_api.rest.dtos;

import lombok.Data;


@Data
public class GrassDto extends PlantDto {

    private CowsDto cow;
    private GoatsDto goat;

}
