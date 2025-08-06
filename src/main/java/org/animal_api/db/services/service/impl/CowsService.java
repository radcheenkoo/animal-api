package org.animal_api.db.services.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.animal_api.db.entities.CowsEntity;
import org.animal_api.db.entities.GoatsEntity;
import org.animal_api.db.entities.GrassEntity;
import org.animal_api.db.repositories.CowsRepository;
import org.animal_api.db.repositories.GrassRepository;
import org.animal_api.db.services.service.AdvancedCRUDService;
import org.animal_api.db.services.service.BaseCRUDService;
import org.animal_api.db.services.service.PlantEaterService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@Slf4j
public class CowsService extends AdvancedCRUDService<CowsEntity, CowsRepository> implements PlantEaterService<CowsEntity> {

//    private final CowsRepository cowsRepository;

    private final GrassRepository grassRepository;

    public CowsService(CowsRepository repository, GrassRepository grassRepository) {
        super(repository);
        this.grassRepository = grassRepository;
    }



    @Override
    public void grassEatBy(String animalName) {

        CowsEntity cow = super.getByName(animalName);

        GrassEntity grass = new GrassEntity();
        grass.setId(null);
        grass.setCow(cow);
        grass.setCreatingDate(LocalDateTime.now());

        grassRepository.save(grass);
    }
}
