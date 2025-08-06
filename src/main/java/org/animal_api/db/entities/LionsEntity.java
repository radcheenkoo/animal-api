package org.animal_api.db.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.extern.slf4j.Slf4j;
import org.animal_api.interfaces.IFood;

import java.util.Date;

@Entity
@Table(name = "lions")
@Slf4j
public class LionsEntity extends AnimalEntity {


    public LionsEntity(){
        super();
    }

    public LionsEntity(String name, Date creatingDate, Date lastModifictionDate){
        super(name, lastModifictionDate);
    }

    @Override
    public void eatInternal(IFood food) {
        log.info(String.format("%s hunt and eat %s.", this.name, food.getFoodName()));
    }
}
