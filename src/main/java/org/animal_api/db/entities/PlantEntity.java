package org.animal_api.db.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@MappedSuperclass
public abstract class PlantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creating_date", nullable = false, updatable = false)
    protected Date creatingDate;


    public PlantEntity(){}

    public PlantEntity(Long id, Date creatingDate) {
        this.id = id;
        this.creatingDate = creatingDate;
    }
}
