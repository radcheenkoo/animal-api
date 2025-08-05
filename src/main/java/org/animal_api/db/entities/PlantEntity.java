package org.animal_api.db.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.animal_api.services.service.interfaces.Consumable;

import java.util.Date;

@Data
@MappedSuperclass
public abstract class PlantEntity extends BaseEntity implements Consumable {


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creating_date", nullable = false, updatable = false)
    protected Date creatingDate;


    public PlantEntity(){}

    public PlantEntity(Long id, Date creatingDate) {
        this.id = id;
        this.creatingDate = creatingDate;
    }
}
