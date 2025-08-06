package org.animal_api.rest.controllers;

import jakarta.validation.Valid;
import org.animal_api.db.entities.BaseEntity;
import org.animal_api.db.repositories.AdvancedRepository;
import org.animal_api.db.repositories.NameRepository;
import org.animal_api.db.services.service.AdvancedCRUDService;
import org.animal_api.rest.dtos.BaseDto;
import org.animal_api.utils.mapper.BaseMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // GET all
    @GetMapping
    public ResponseEntity<List<D>> getAll() {
        List<D> dtos = mapper.entityListToDtoList(service.getAll());
        return ResponseEntity.ok(dtos);
    }

    // GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<D> getById(@PathVariable Long id) {
        D dto = mapper.entityToDto(service.read(id));
        return ResponseEntity.ok(dto);
    }

    // GET by name (через query parameter)
    @GetMapping("/search")
    public ResponseEntity<D> getByName(@RequestParam String name) {
        D dto = mapper.entityToDto(service.getByName(name));
        return ResponseEntity.ok(dto);
    }

    // POST create
    @PostMapping
    public ResponseEntity<D> create(@RequestBody @Valid D dto) {
        E entity = mapper.dtoToEntity(dto);
        E saved = service.create(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.entityToDto(saved));
    }

    // PUT update
    @PutMapping
    public ResponseEntity<D> update(@RequestBody @Valid D dto) {
        E entity = mapper.dtoToEntity(dto);
        E updated = service.update(entity);
        return ResponseEntity.ok(mapper.entityToDto(updated));
    }

    // DELETE by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
