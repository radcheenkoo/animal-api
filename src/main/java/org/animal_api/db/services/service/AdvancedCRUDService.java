package org.animal_api.db.services.service;

import org.animal_api.db.entities.BaseEntity;
import org.animal_api.db.repositories.NameRepository;
import org.animal_api.utils.exceptions.AnimalNameIsNullException;
import org.animal_api.utils.exceptions.EntityNotFoundException;

public class AdvancedCRUDService <E extends BaseEntity, R extends NameRepository<E>> extends BaseCRUDService<E, R> {

    protected AdvancedCRUDService(R repository) {
        super(repository);
    }

    public E getByName(String name) {

        if (name == null || name.isBlank()){
            throw new AnimalNameIsNullException("Name Cannot be null or empty.");
        }
        return repository.findByName(name).orElseThrow(() -> new EntityNotFoundException("Entity not found bt name: " + name));
    }

}
