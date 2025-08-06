package org.animal_api.rest.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.animal_api.db.entities.BaseEntity;
import org.animal_api.rest.dtos.BaseDto;
import org.animal_api.services.mapper.BaseMapper;
import org.animal_api.services.service.BaseCRUDService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
public abstract class BaseController<R extends JpaRepository<E, Long>, S
        extends BaseCRUDService<E, R>, E extends BaseEntity, D extends BaseDto, M extends BaseMapper<E, D>> {

    private final M mapper;
    private final S service;

    @GetMapping("/{id}")
    public D getById(@PathVariable Long id){
        return mapper.entityToDto(service.read(id));
    }

    @PostMapping
    public D create(@Valid @RequestBody D dto){
        return mapper.entityToDto(service.create(mapper.dtoToEntity(dto)));
    }

    @PutMapping
    public D update(@Valid @RequestBody D dto){
        return mapper.entityToDto(service.update(mapper.dtoToEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.delete(id);
    }

}
