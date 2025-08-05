package org.animal_api.services.service;

import lombok.extern.slf4j.Slf4j;
import org.animal_api.db.entities.BaseEntity;
import org.animal_api.services.exceptions.EntityIsNullException;
import org.animal_api.services.exceptions.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Objects;

@Slf4j
public abstract class BaseCRUDService<T extends BaseEntity, R extends JpaRepository<T, Long>> {

    protected final R repository;

    protected BaseCRUDService(R repository){
        this.repository = repository;
    }

    public T create(T t) {
        if (Objects.isNull(t)){
           throw new EntityIsNullException("Entity -> " + t + " is null, it cannot be saved.");
        }
        log.info("creating entity: {}", t);

        return repository.save(t);
    }

    public T update(T t){

        if (Objects.isNull(t)){
            throw new EntityIsNullException("Entity by id " + t.getId() + " is null.");
        }

        Long id = t.getId();
        if (id == null || !repository.existsById(id)){
            throw new EntityNotFoundException("Cannot update: entity not found with ID " + id);
        }
        log.info("Updating entity with ID: {}", id);

        return repository.save(t);
    }


    public T read(Long id){

        if (Objects.isNull(id)){
            throw new IllegalArgumentException("ID cannot be null");
        }

        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found by id " + id));

    }

    public void delete(T t){

        if (Objects.isNull(t)){
            throw new EntityIsNullException("Entity by id " + t.getId() + " is null.");
        }

        Long id = t.getId();
        if (id == null || !repository.existsById(id)){
            throw new EntityNotFoundException("Cannot update: entity not found with ID " + id);
        }

        repository.delete(t);
        log.info("Updating entity with ID: {}", id);


    }

}
