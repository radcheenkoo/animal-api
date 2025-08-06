package org.animal_api.services.mapper;

import org.animal_api.db.entities.LionsEntity;
import org.animal_api.rest.dtos.LionsDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface LionsMapper extends BaseMapper<LionsEntity, LionsDto> {

//    @Mapping(source = "id", target = "id")
//    @Mapping(source = "name", target = "name")
//    @Mapping(source = "creatingDate", target = "creatingDate")
//    @Mapping(source = "lastModificationDate", target = "lastModificationDate")
    @Override
    LionsDto entityToDto(LionsEntity entity);

//    @Mapping(source = "id", target = "id")
//    @Mapping(source = "name", target = "name")
//    @Mapping(source = "creatingDate", target = "creatingDate")
//    @Mapping(source = "lastModificationDate", target = "lastModificationDate")
    @Override
    LionsEntity dtoToEntity(LionsDto dto);
}
