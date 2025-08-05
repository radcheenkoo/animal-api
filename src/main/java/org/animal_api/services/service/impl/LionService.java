package org.animal_api.services.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.animal_api.db.entities.LionsEntity;
import org.animal_api.db.repositories.LionsRepository;
import org.animal_api.services.mapper.LionsMapper;
import org.animal_api.services.service.AnimalService;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@AllArgsConstructor
@Slf4j
public class LionService implements AnimalService<LionsEntity> {

    private final LionsMapper lionsMapper;
    private final LionsRepository lionsRepository;


    @Override
    public LionsEntity createAnimal(LionsEntity animal) {
        return null;
    }

    @Override
    public LionsEntity deleteAnimal(LionsEntity animal) {
        return null;
    }

    @Override
    public LionsEntity updateAnimal(LionsEntity animal) {
        return null;
    }

    @Override
    public LionsEntity getAnimalByName(String name) {
        return null;
    }

    @Override
    public HashSet<LionsEntity> getAllPredatoryAnimals() {
        return null;
    }

    @Override
    public HashSet<LionsEntity> getAllHerbivorousAnimals() {
        return null;
    }
}
