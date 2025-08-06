package org.animal_api.db.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.animal_api.db.entities.interfaces.Consumable;

@Slf4j
@Data
@Entity
@Table(name = "grass")
public class GrassEntity extends PlantEntity implements Consumable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cow_id", foreignKey = @ForeignKey(name = "fk_schedule_grass_cow"))
    private CowsEntity cow;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goat_id", foreignKey = @ForeignKey(name = "fk_schedule_grass_goat"))
    private GoatsEntity goat;

    public GrassEntity(){}
    @Override
    public String getFoodName() {
        return "Grass" + this.id ;
    }
}
