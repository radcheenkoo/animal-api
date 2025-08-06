package org.animal_api.db.services.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.animal_api.db.entities.AnimalEntity;
import org.animal_api.db.entities.LionsEntity;
import org.animal_api.db.entities.interfaces.Consumable;
import org.animal_api.db.repositories.CowsRepository;
import org.animal_api.db.repositories.GoatsRepository;
import org.animal_api.db.repositories.LionsRepository;
import org.animal_api.db.repositories.NameRepository;
import org.animal_api.db.services.service.AdvancedCRUDService;
import org.animal_api.db.services.service.AnimalEaterService;
import org.animal_api.utils.enums.FoodType;
import org.animal_api.utils.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class LionService extends AdvancedCRUDService<LionsEntity, LionsRepository> implements AnimalEaterService<LionsEntity>{

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

        switch (foodType){
            case GOAT -> eatSaveHelpers(entity, goatsRepository, foodName);
            case COW -> eatSaveHelpers(entity, cowsRepository, foodName);
            default -> throw new IllegalArgumentException("Food type unsupported: " + foodType);
        }

    }

    private <E extends AnimalEntity> void eatSaveHelpers(LionsEntity lion, NameRepository<E> repo, String foodName){

        E food = repo.findByName(foodName)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found in DB by name: " + foodName + ", maybe this entity does not exists."));

        lion.eat((Consumable) food);
        super.update(lion);
    }
}
