package org.animal_api.utils.mapper;

import org.animal_api.db.entities.CowsEntity;
import org.animal_api.rest.dtos.CowsDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CowsMapper extends BaseMapper<CowsEntity, CowsDto>{}
