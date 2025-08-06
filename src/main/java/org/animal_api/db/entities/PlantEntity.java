package org.animal_api.db.entities;

import jakarta.persistence.*;
import org.animal_api.services.service.interfaces.Consumable;


@MappedSuperclass
public abstract class PlantEntity extends BaseEntity implements Consumable {

    public PlantEntity(){}
}
