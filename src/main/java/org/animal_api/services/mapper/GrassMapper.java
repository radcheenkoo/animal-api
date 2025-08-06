package org.animal_api.services.mapper;


import org.animal_api.db.entities.GrassEntity;
import org.animal_api.rest.dtos.GrassDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GrassMapper extends BaseMapper<GrassEntity, GrassDto> {


//    @Mapping(source = "id", target = "id")
//    @Mapping(source = "creatingDate", target = "creatingDate")
//    @Mapping(source = "cow", target = "cow")
//    @Mapping(source = "goat", target = "goat")
    @Override
    GrassDto entityToDto(GrassEntity entity);


//    @Mapping(source = "id", target = "id")
//    @Mapping(source = "creatingDate", target = "creatingDate")
//    @Mapping(source = "cow", target = "cow")
//    @Mapping(source = "goat", target = "goat")
    @Override
    GrassEntity dtoToEntity(GrassDto dto);

}
