package org.animal_api.utils.mapper;

import org.animal_api.db.entities.LionsEntity;
import org.animal_api.rest.dtos.LionsDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface LionsMapper extends BaseMapper<LionsEntity, LionsDto> {}
