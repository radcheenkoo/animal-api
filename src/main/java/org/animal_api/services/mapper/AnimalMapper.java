package org.animal_api.services.mapper;

import org.animal_api.db.entities.AnimalEntity;
import org.animal_api.services.dtos.AnimalDto;

public interface AnimalMapper<E extends AnimalEntity, D extends AnimalDto>{

    public D entityToDto(E entity);
    public E dtoToEntity(D dto);

}
