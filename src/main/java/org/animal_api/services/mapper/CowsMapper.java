package org.animal_api.services.mapper;

import org.animal_api.db.entities.CowsEntity;
import org.animal_api.services.dtos.CowsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CowsMapper extends AnimalMapper<CowsEntity, CowsDto>{

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "creatingDate", target = "creatingDate")
    @Mapping(source = "lastModificationDate", target = "lastModificationDate")
    @Mapping(source = "lion", target = "lion")
    @Override
    CowsDto entityToDto(CowsEntity entity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "creatingDate", target = "creatingDate")
    @Mapping(source = "lastModificationDate", target = "lastModificationDate")
    @Mapping(source = "lion", target = "lion")
    @Override
    CowsEntity dtoToEntity(CowsDto dto);

}
