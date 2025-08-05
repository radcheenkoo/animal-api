package org.animal_api.services.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.animal_api.db.entities.GoatsEntity;
import org.animal_api.db.repositories.GoatsRepository;
import org.animal_api.services.mapper.GoatsMapper;
import org.animal_api.services.service.AnimalService;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@AllArgsConstructor
@Slf4j
public class GoatService implements AnimalService<GoatsEntity> {

    private final GoatsMapper goatsMapper;
    private final GoatsRepository goatsRepository;

    @Override
    public GoatsEntity createAnimal(GoatsEntity animal) {
        return null;
    }

    @Override
    public GoatsEntity deleteAnimal(GoatsEntity animal) {
        return null;
    }

    @Override
    public GoatsEntity updateAnimal(GoatsEntity animal) {
        return null;
    }

    @Override
    public GoatsEntity getAnimalByName(String name) {
        return null;
    }

    @Override
    public HashSet<GoatsEntity> getAllPredatoryAnimals() {
        return null;
    }

    @Override
    public HashSet<GoatsEntity> getAllHerbivorousAnimals() {
        return null;
    }
}
