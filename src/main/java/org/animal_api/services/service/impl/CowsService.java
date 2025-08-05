package org.animal_api.services.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.animal_api.db.entities.CowsEntity;
import org.animal_api.db.repositories.CowsRepository;
import org.animal_api.services.mapper.CowsMapper;
import org.animal_api.services.service.AnimalService;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@AllArgsConstructor
@Slf4j
public class CowsService implements AnimalService<CowsEntity> {

    private final CowsMapper cowsMapper;
    private final CowsRepository cowsRepository;

    @Override
    public CowsEntity createAnimal(CowsEntity animal) {
        return null;
    }

    @Override
    public CowsEntity deleteAnimal(CowsEntity animal) {
        return null;
    }

    @Override
    public CowsEntity updateAnimal(CowsEntity animal) {
        return null;
    }

    @Override
    public CowsEntity getAnimalByName(String name) {
        return null;
    }

    @Override
    public HashSet<CowsEntity> getAllPredatoryAnimals() {
        return null;
    }

    @Override
    public HashSet<CowsEntity> getAllHerbivorousAnimals() {
        return null;
    }
}
