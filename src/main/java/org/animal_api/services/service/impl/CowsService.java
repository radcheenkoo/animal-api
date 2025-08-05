package org.animal_api.services.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.animal_api.db.entities.CowsEntity;
import org.animal_api.db.repositories.CowsRepository;
import org.animal_api.services.service.AnimalService;
import org.animal_api.services.service.BaseCRUDService;
import org.animal_api.services.service.interfaces.Consumable;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class CowsService extends BaseCRUDService<CowsEntity, CowsRepository> implements AnimalService<CowsEntity> {

//    private final CowsRepository cowsRepository;

    public CowsService(CowsRepository repository) {
        super(repository);
    }

    @Override
    public void eat(Consumable consumable) {

    }
}
