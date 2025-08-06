package org.animal_api.db.services.service;

import org.animal_api.db.entities.AnimalEntity;
import org.animal_api.utils.enums.FoodType;


public interface AnimalEaterService<T extends AnimalEntity>{
    void eat(String name, String foodName, FoodType foodType);
}
