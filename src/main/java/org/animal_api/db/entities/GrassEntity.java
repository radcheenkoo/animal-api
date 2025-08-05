package org.animal_api.db.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
@Data
@Entity
@Table(name = "grass")
public class GrassEntity implements IFood{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creating_date", nullable = false, updatable = false)
    private Date creatingDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cow_id", referencedColumnName = "id")
    private CowsEntity cow;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goat_id", referencedColumnName = "id")
    private GoatsEntity goat;

    public GrassEntity(){}

    public GrassEntity(Date creatingDate, CowsEntity cow, GoatsEntity goat){
        this.creatingDate = creatingDate;
        this.cow = cow;
        this.goat = goat;
    }

    @Override
    public String getFoodName() {
        return "Grass" + this.id ;
    }
}
