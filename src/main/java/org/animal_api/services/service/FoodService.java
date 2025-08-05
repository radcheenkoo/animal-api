package org.animal_api.services.service;

import org.animal_api.db.entities.PlantEntity;
import org.animal_api.services.service.interfaces.Consumable;
import org.animal_api.services.service.interfaces.Eater;

public interface FoodService<T extends PlantEntity> extends Eater<Consumable> {

}
