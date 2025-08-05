package org.animal_api.services.dtos;

import lombok.Data;


@Data
public class GrassDto extends PlantDto {

    private CowsDto cow;
    private GoatsDto goat;

}
