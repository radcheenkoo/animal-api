package org.animal_api.db.services.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.animal_api.db.entities.CowsEntity;
import org.animal_api.db.entities.GoatsEntity;
import org.animal_api.db.entities.LionsEntity;
import org.animal_api.db.entities.interfaces.Consumable;
import org.animal_api.db.repositories.CowsRepository;
import org.animal_api.db.repositories.GoatsRepository;
import org.animal_api.db.repositories.LionsRepository;
import org.animal_api.db.services.service.AdvancedCRUDService;
import org.animal_api.db.services.service.AnimalEaterService;
import org.animal_api.db.services.service.BaseCRUDService;
import org.animal_api.utils.enums.FoodType;
import org.animal_api.utils.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class LionService extends AdvancedCRUDService<LionsEntity, LionsRepository> implements AnimalEaterService<LionsEntity>{

//    private final LionsRepository lionsRepository;
    private final CowsRepository cowsRepository;
    private final GoatsRepository goatsRepository;

    protected LionService(LionsRepository repository, CowsRepository cowsRepository, GoatsRepository goatsRepository) {
        super(repository);
        this.cowsRepository = cowsRepository;
        this.goatsRepository = goatsRepository;
    }

    @Override
    public void eat(String name, String foodName, FoodType foodType) {

        LionsEntity entity = super.getByName(name);

        if (foodType == FoodType.COW){

            CowsEntity cow = cowsRepository.findByName(foodName)
                    .orElseThrow(() -> new EntityNotFoundException("Cows not found in DB by name: " + foodName + ", maybe this entity does not exists."));

            entity.eat(cow);
            super.update(entity);

        } else if (foodType == FoodType.GOAT) {
            GoatsEntity goat = goatsRepository.findByName(foodName)
                    .orElseThrow(() -> new EntityNotFoundException("Goats not found in DB by name: " + foodName + ", maybe this entity does not exists."));

            entity.eat(goat);
            super.update(entity);

        }
    }
}
