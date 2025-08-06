package org.animal_api.db.services.service;

import org.animal_api.db.entities.AnimalEntity;
import org.animal_api.db.entities.BaseEntity;

public interface PlantEaterService<T extends AnimalEntity>  {

    void grassEatBy(String name);

}
