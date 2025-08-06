package org.animal_api.db.repositories;

import org.animal_api.db.entities.GoatsEntity;
import org.springframework.stereotype.Repository;


@Repository
public interface GoatsRepository extends NameRepository<GoatsEntity>, AdvancedRepository<GoatsEntity> {

}
