package org.animal_api.rest.controllers;

import jakarta.validation.Valid;
import org.animal_api.db.entities.BaseEntity;
import org.animal_api.db.repositories.AdvancedRepository;
import org.animal_api.db.repositories.NameRepository;
import org.animal_api.db.services.service.AdvancedCRUDService;
import org.animal_api.rest.dtos.BaseDto;
import org.animal_api.utils.mapper.BaseMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController<R extends AdvancedRepository<E> & NameRepository<E>, S
        extends AdvancedCRUDService<E, R>, E extends BaseEntity, D extends BaseDto, M extends BaseMapper<E, D>> {

    private final M mapper;
    final S service;

    protected BaseController(M mapper, S service) {
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping("/all")
    public List<D> getAll(){
        return mapper.entityListToDtoList(service.getAll());
    }

    @GetMapping("/id/{id}")
    public D getById(@PathVariable Long id){
        return mapper.entityToDto(service.read(id));
    }

    @GetMapping("/name/{name}")
    public D getByName(@PathVariable String name){
        return mapper.entityToDto(service.getByName(name));
    }

    @PostMapping
    public D create(@Valid @RequestBody D dto){
        return mapper.entityToDto(service.create(mapper.dtoToEntity(dto)));
    }

    @PutMapping
    public D update(@Valid @RequestBody D dto){
        return mapper.entityToDto(service.update(mapper.dtoToEntity(dto)));
    }

    @DeleteMapping
    public void deleteById(@PathVariable Long id) {
        service.delete(id);
    }


}
