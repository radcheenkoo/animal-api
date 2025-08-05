package org.animal_api.db.entities;


import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
@Entity
@Table(name = "goats")
public class GoatsEntity extends Animal implements IFood{


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lion_id", referencedColumnName = "id")
    private LionsEntity lion;

    public GoatsEntity(){
        super();
    }

    public GoatsEntity(String name, Date creatingDate, Date lastModifictionDate){
        super(name, creatingDate, lastModifictionDate);
    }

    @Override
    public void eatInternal(IFood food) {
        log.info(String.format("%s eats %s.", this.name, food.getFoodName()));
    }

    @Override
    public String getFoodName() {
        return this.name;
    }
}
