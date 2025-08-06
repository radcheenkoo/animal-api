package org.animal_api.db.services.service;

import org.animal_api.db.entities.AnimalEntity;

public interface PlantEaterService<T extends AnimalEntity>  {

    void grassEatBy(String name);

}
