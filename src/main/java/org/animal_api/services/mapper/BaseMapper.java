package org.animal_api.services.mapper;

import org.animal_api.db.entities.BaseEntity;
import org.animal_api.rest.dtos.BaseDto;

import java.util.List;

public interface BaseMapper <E extends BaseEntity, D extends BaseDto>{
    public D entityToDto(E entity);
    public E dtoToEntity(D dto);

    List<D> entityListToDtoList(List<E> entities);
    List<E> dtoListToEntityList(List<D> dtos);

}
