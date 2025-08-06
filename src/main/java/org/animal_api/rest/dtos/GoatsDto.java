package org.animal_api.rest.dtos;

import lombok.Getter;
import lombok.Setter;

public class GoatsDto extends AnimalDto {

    @Getter
    @Setter
    private LionsDto lion;

}
