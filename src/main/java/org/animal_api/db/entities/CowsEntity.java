package org.animal_api.db.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.animal_api.db.entities.interfaces.Consumable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Entity
@Table(name = "cows")
@Getter
@Setter
public class CowsEntity extends AnimalEntity implements Consumable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lion_id", foreignKey = @ForeignKey(name = "fk_schedule_cow_lion"))
    private LionsEntity lion;

    @OneToMany(mappedBy = "cow", cascade = CascadeType.ALL)
    List<GrassEntity> eatenGrass = new ArrayList<>();

    public CowsEntity(){
        super();
    }

    public CowsEntity(String name, LocalDateTime creatingDate, LocalDateTime lastModifictionDate){
        super(name, lastModifictionDate);
    }

    @Override
    public String getFoodName() {
        return this.name;
    }
}
