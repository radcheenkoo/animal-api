package org.animal_api.services.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.animal_api.db.entities.LionsEntity;
import org.animal_api.db.repositories.LionsRepository;
import org.animal_api.services.service.AnimalService;
import org.animal_api.services.service.BaseCRUDService;
import org.animal_api.services.service.interfaces.Consumable;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class LionService extends BaseCRUDService<LionsEntity, LionsRepository> implements AnimalService<LionsEntity>{

//    private final LionsRepository lionsRepository;

    protected LionService(LionsRepository repository) {
        super(repository);
    }

    @Override
    public void eat(Consumable consumable) {

    }
}
