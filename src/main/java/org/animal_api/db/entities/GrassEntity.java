package org.animal_api.db.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.animal_api.interfaces.IFood;

@Slf4j
@Data
@Entity
@Table(name = "grass")
public class GrassEntity extends PlantEntity implements IFood {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cow_id", referencedColumnName = "id")
    private CowsEntity cow;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goat_id", referencedColumnName = "id")
    private GoatsEntity goat;

    public GrassEntity(){}
    @Override
    public String getFoodName() {
        return "Grass" + this.id ;
    }
}
