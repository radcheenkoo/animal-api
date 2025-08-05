package org.animal_api.db.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@MappedSuperclass
public abstract class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "name", nullable = false, unique = true, length = 100)
    protected String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creating_date", nullable = false, updatable = false)
    protected Date creatingDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_modification_date", nullable = false)
    protected Date LastModificationDate;

    public Animal(String name, Date creatingDate, Date lastModificationDate) {
        this.name = name;
        this.creatingDate = creatingDate;
        LastModificationDate = lastModificationDate;
    }

    public Animal() {
    }

    public abstract void eatInternal(IFood food);

}
