package org.animal_api.services.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.animal_api.db.entities.GrassEntity;
import org.animal_api.db.repositories.GrassRepository;
import org.animal_api.services.mapper.GrassMapper;
import org.animal_api.services.service.PlantService;
import org.springframework.stereotype.Service;

import java.util.HashSet;


@Service
@AllArgsConstructor
@Slf4j
public class GrassService implements PlantService<GrassEntity> {

    private final GrassMapper grassMapper;
    private final GrassRepository repository;


    @Override
    public GrassEntity createPlant(GrassEntity animal) {
        return null;
    }

    @Override
    public GrassEntity deletePlant(GrassEntity animal) {
        return null;
    }

    @Override
    public GrassEntity updatePlant(GrassEntity animal) {
        return null;
    }

    @Override
    public GrassEntity getPlantByName(String name) {
        return null;
    }

    @Override
    public HashSet<GrassEntity> getAllPlants() {
        return null;
    }
}

