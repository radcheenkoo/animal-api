package org.animal_api.services.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.animal_api.db.entities.GoatsEntity;
import org.animal_api.db.repositories.GoatsRepository;
import org.animal_api.services.service.AnimalService;
import org.animal_api.services.service.BaseCRUDService;
import org.animal_api.services.service.interfaces.Consumable;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class GoatService extends BaseCRUDService<GoatsEntity, GoatsRepository> implements AnimalService<GoatsEntity>{

//    private final GoatsRepository goatsRepository;

    protected GoatService(GoatsRepository repository) {
        super(repository);
    }

    @Override
    public void eat(Consumable consumable) {

    }
}
