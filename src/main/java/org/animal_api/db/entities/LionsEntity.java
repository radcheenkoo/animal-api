package org.animal_api.db.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.animal_api.db.entities.interfaces.Consumable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lions", indexes = {
        @Index(name = "idx_lion_name", columnList = "name")
})
@Slf4j
@Getter
@Setter
public class LionsEntity extends AnimalEntity {


    @OneToMany(mappedBy = "lion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CowsEntity> eatenCows = new ArrayList<>();

    @OneToMany(mappedBy = "lion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GoatsEntity> eatenGoats = new ArrayList<>();

    public LionsEntity(){
        super();
    }

    public LionsEntity(String name, LocalDateTime creatingDate, LocalDateTime lastModifictionDate){
        super(name, lastModifictionDate);
    }

    public void eat(Consumable food){
        if (food instanceof CowsEntity cow){
            cow.setLion(this);
            this.eatenCows.add(cow);
        }else if (food instanceof GoatsEntity goat){
            goat.setLion(this);
            this.eatenGoats.add(goat);
        }
        else {
            throw new IllegalArgumentException("This food lion don't eat.");
        }

    }

}
