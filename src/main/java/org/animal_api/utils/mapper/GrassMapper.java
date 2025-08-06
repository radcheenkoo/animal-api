package org.animal_api.utils.mapper;


import org.animal_api.db.entities.GrassEntity;
import org.animal_api.rest.dtos.GrassDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GrassMapper extends BaseMapper<GrassEntity, GrassDto> {}
