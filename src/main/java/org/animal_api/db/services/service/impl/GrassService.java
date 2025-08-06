package org.animal_api.db.services.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.animal_api.db.entities.GrassEntity;
import org.animal_api.db.repositories.GrassRepository;
import org.animal_api.db.services.service.BaseCRUDService;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class GrassService extends BaseCRUDService<GrassEntity, GrassRepository>{

    protected GrassService(GrassRepository repository) {
        super(repository);
    }
}

