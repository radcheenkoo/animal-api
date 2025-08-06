package org.animal_api.db.entities;

import jakarta.persistence.*;


@MappedSuperclass
public abstract class PlantEntity extends BaseEntity {

    public PlantEntity(){}
}
