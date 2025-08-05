package org.animal_api.services.mapper;

import org.animal_api.db.entities.GoatsEntity;
import org.animal_api.services.dtos.GoatsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GoatsMapper extends AnimalMapper<GoatsEntity, GoatsDto>{

//    @Mapping(source = "id", target = "id")
//    @Mapping(source = "name", target = "name")
//    @Mapping(source = "creatingDate", target = "creatingDate")
//    @Mapping(source = "lastModificationDate", target = "lastModificationDate")
//    @Mapping(source = "lion", target = "lion")
    @Override
    GoatsEntity dtoToEntity(GoatsDto dto);

//    @Mapping(source = "id", target = "id")
//    @Mapping(source = "name", target = "name")
//    @Mapping(source = "creatingDate", target = "creatingDate")
//    @Mapping(source = "lastModificationDate", target = "lastModificationDate")
//    @Mapping(source = "lion", target = "lion")
    @Override
    GoatsDto entityToDto(GoatsEntity entity);
}
