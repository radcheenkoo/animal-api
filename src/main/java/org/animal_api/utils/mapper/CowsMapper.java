package org.animal_api.utils.mapper;

import org.animal_api.db.entities.CowsEntity;
import org.animal_api.rest.dtos.CowsDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CowsMapper extends BaseMapper<CowsEntity, CowsDto>{

//    @Mapping(source = "id", target = "id")
//    @Mapping(source = "name", target = "name")
//    @Mapping(source = "creatingDate", target = "creatingDate")
//    @Mapping(source = "lastModificationDate", target = "lastModificationDate")
//    @Mapping(source = "lion", target = "lion")
    @Override
    CowsDto entityToDto(CowsEntity entity);

//    @Mapping(source = "id", target = "id")
//    @Mapping(source = "name", target = "name")
//    @Mapping(source = "creatingDate", target = "creatingDate")
//    @Mapping(source = "lastModificationDate", target = "lastModificationDate")
//    @Mapping(source = "lion", target = "lion")
    @Override
    CowsEntity dtoToEntity(CowsDto dto);

}
