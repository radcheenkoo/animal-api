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
@Table(name = "goats", indexes = {
        @Index(name = "idx_goat_name", columnList = "name")
})
@Getter
@Setter
public class GoatsEntity extends AnimalEntity implements Consumable {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lion_id", foreignKey = @ForeignKey(name = "fk_schedule_goat_lion"))
    private LionsEntity lion;

    @OneToMany(mappedBy = "goat", cascade = CascadeType.ALL)
    List<GrassEntity> eatenGrass = new ArrayList<>();

    public GoatsEntity(){
        super();
    }

    public GoatsEntity(String name, LocalDateTime creatingDate, LocalDateTime lastModifictionDate){
        super(name, lastModifictionDate);
    }

    @Override
    public String getFoodName() {
        return this.name;
    }
}
