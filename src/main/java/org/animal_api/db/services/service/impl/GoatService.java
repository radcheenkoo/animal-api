package org.animal_api.db.services.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.animal_api.db.entities.GoatsEntity;
import org.animal_api.db.entities.GrassEntity;
import org.animal_api.db.repositories.GoatsRepository;
import org.animal_api.db.repositories.GrassRepository;
import org.animal_api.db.services.service.AdvancedCRUDService;
import org.animal_api.db.services.service.PlantEaterService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@Slf4j
public class GoatService extends AdvancedCRUDService<GoatsEntity, GoatsRepository> implements PlantEaterService<GoatsEntity> {

    private final GrassRepository grassRepository;

    protected GoatService(GoatsRepository repository, GrassRepository grassRepository) {
        super(repository);
        this.grassRepository = grassRepository;
    }


    @Override
    public void grassEatBy(String animalName) {

        GoatsEntity goat = super.getByName(animalName);

        GrassEntity grass = new GrassEntity();
        grass.setId(null);
        grass.setGoat(goat);
        grass.setCreatingDate(LocalDateTime.now());

        grassRepository.save(grass);
    }
}
