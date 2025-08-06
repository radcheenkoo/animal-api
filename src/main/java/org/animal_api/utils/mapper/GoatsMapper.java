package org.animal_api.utils.mapper;

import org.animal_api.db.entities.GoatsEntity;
import org.animal_api.rest.dtos.GoatsDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GoatsMapper extends BaseMapper<GoatsEntity, GoatsDto>{}
