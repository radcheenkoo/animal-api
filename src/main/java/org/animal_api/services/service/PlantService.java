package org.animal_api.services.service;

import org.animal_api.db.entities.PlantEntity;

import java.util.HashSet;

public interface PlantService <T extends PlantEntity> {

    T createPlant(T plant);
    T deletePlant(T plant);
    T updatePlant (T plant);
    T getPlantByName(String name);
    HashSet<T> getAllPlants();

}
