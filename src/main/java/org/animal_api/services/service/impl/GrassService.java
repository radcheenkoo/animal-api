package org.animal_api.services.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.animal_api.db.entities.GrassEntity;
import org.animal_api.services.service.FoodService;
import org.animal_api.services.service.interfaces.Consumable;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
@Slf4j
public class GrassService implements FoodService<GrassEntity> {



    @Override
    public void eat(Consumable consumable) {

    }
}

