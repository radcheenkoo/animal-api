package org.animal_api.rest.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class LionsDto extends AnimalDto {

    private List<CowsDto> eatenCows = new ArrayList<>();
    private List<GoatsDto> eatenGoats = new ArrayList<>();

}
