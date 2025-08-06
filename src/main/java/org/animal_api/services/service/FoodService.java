package org.animal_api.services.service;

import org.animal_api.db.entities.AnimalEntity;
import org.animal_api.db.entities.PlantEntity;

public interface FoodService<T extends PlantEntity>  {

    T eatBy(AnimalEntity animal);

}
