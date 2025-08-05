package org.animal_api.db.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Entity
@Table(name = "lions")
@Slf4j
public class LionsEntity extends Animal{


    public LionsEntity(){
        super();
    }

    public LionsEntity(String name, Date creatingDate, Date lastModifictionDate){
        super(name, creatingDate, lastModifictionDate);
    }

    @Override
    public void eatInternal(IFood food) {
        log.info(String.format("%s hunt and eat %s.", this.name, food.getFoodName()));
    }
}
