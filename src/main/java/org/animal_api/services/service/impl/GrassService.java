package org.animal_api.services.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.animal_api.db.entities.AnimalEntity;
import org.animal_api.db.entities.CowsEntity;
import org.animal_api.db.entities.GoatsEntity;
import org.animal_api.db.entities.GrassEntity;
import org.animal_api.services.service.FoodService;
import org.animal_api.services.service.interfaces.Consumable;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
@Slf4j
public class GrassService implements FoodService<GrassEntity> {


    @Override
    public GrassEntity eatBy(AnimalEntity animal) {

        GrassEntity grass = new GrassEntity();

        if (animal instanceof CowsEntity){
            grass.setCow((CowsEntity) animal);
        }
        if (animal instanceof GoatsEntity){
            grass.setGoat((GoatsEntity) animal);
        }

        log.info(animal.getName() + " eats " + grass.getFoodName());

        return grass;
    }
}

