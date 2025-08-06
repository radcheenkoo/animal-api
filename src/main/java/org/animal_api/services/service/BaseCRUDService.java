package org.animal_api.services.service;

import lombok.extern.slf4j.Slf4j;
import org.animal_api.db.entities.BaseEntity;
import org.animal_api.services.exceptions.EntityIsNullException;
import org.animal_api.services.exceptions.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Objects;

@Slf4j
public abstract class BaseCRUDService<E extends BaseEntity, R extends JpaRepository<E, Long>> {

    protected final R repository;

    protected BaseCRUDService(R repository){
        this.repository = repository;
    }

    public E create(E e) {
        if (Objects.isNull(e)){
           throw new EntityIsNullException("Entity -> " + e + " is null, it cannot be saved.");
        }
        log.info("creating entity: {}", e);

        return repository.save(e);
    }

    public E update(E e){

        if (e == null){
            throw new EntityIsNullException("Entity is null.");
        }

        Long id = e.getId();
        if (id == null || !repository.existsById(id)){
            throw new EntityNotFoundException("Cannot update: entity not found with ID " + id);
        }
        log.info("Updating entity with ID: {}", id);

        return repository.save(e);
    }


    public E read(Long id){

        if (Objects.isNull(id)){
            throw new IllegalArgumentException("ID cannot be null");
        }

        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found by id " + id));

    }

    public void delete(Long id){

        if (id == null){
            throw new EntityIsNullException("Id is null.");
        }

        if (!repository.existsById(id)){
            throw new EntityNotFoundException("Cannot delete: entity not found with ID " + id);
        }

        repository.deleteById(id);
        log.info("Updating entity with ID: {}", id);


    }

}
