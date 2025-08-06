package org.animal_api.rest.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.util.Date;



@Getter
@Setter
@Validated
public abstract class BaseDto {

    protected Long id;
    protected Date creatingDate;

}
