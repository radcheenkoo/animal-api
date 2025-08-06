package org.animal_api.rest.dtos;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CowsDto extends AnimalDto {

    private LionsDto lion;

}
