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
public abstract class AnimalDto {

    protected Long id;
    protected String name;
    protected Date creatingDate;
    protected Date lastModificationDate;

}
