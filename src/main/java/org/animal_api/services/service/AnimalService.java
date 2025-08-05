package org.animal_api.services.service;

import org.animal_api.db.entities.AnimalEntity;

import java.util.HashSet;


public interface AnimalService<T extends AnimalEntity>{

    T createAnimal(T animal);
    T deleteAnimal(T animal);
    T updateAnimal(T animal);
    T getAnimalByName(String name);
    HashSet<T> getAllPredatoryAnimals();
    HashSet<T> getAllHerbivorousAnimals();

}
