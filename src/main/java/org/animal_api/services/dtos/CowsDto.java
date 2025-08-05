package org.animal_api.services.dtos;

import lombok.Getter;
import lombok.Setter;


public class CowsDto extends AnimalDto {
    @Getter
    @Setter
    private LionsDto lion;

}
