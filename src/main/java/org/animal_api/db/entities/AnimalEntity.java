package org.animal_api.db.entities;


import jakarta.persistence.*;
import lombok.Data;
import org.animal_api.interfaces.IFood;
import org.animal_api.services.service.interfaces.Consumable;

import java.util.Date;

@Data
@MappedSuperclass
public abstract class AnimalEntity extends BaseEntity implements Consumable {


    @Column(name = "name", nullable = false, unique = true, length = 100)
    protected String name;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_modification_date", nullable = false)
    protected Date lastModificationDate;

    public AnimalEntity(String name, Date lastModificationDate) {
        this.name = name;
        this.lastModificationDate = lastModificationDate;
    }

    public AnimalEntity() {
    }

    public abstract void eatInternal(IFood food);

}
