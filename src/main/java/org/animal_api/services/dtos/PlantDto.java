package org.animal_api.services.dtos;


import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Validated
public abstract class PlantDto {

    protected Long id;
    protected Date creatingDate;
}
