package org.animal_api.rest.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;



@Getter
@Setter
@Validated
public abstract class BaseDto {

    protected Long id;
    protected LocalDateTime creatingDate;

}
