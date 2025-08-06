package org.animal_api.rest.dtos;


import lombok.*;
import org.springframework.validation.annotation.Validated;
import java.util.Date;


@Getter
@Setter
@Validated
public abstract class AnimalDto extends BaseDto {

    protected String name;
    protected Date lastModificationDate;

}
