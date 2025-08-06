package org.animal_api.db.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class AnimalEntity extends BaseEntity {


    @Column(name = "name", nullable = false, unique = true, length = 100)
    protected String name;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_modification_date", nullable = false)
    protected LocalDateTime lastModificationDate;

    public AnimalEntity(String name, LocalDateTime lastModificationDate) {
        this.name = name;
        this.lastModificationDate = lastModificationDate;
    }

    public AnimalEntity() {
    }
}
