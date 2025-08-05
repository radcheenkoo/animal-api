package org.animal_api.services.mapper;

import org.animal_api.db.entities.PlantEntity;
import org.animal_api.services.dtos.PlantDto;

public interface PlantMapper<E extends PlantEntity, D extends PlantDto> {

    E dtoToEntity(D dto);
    D entityToDto(E entity);

}
