package org.animal_api.db.repositories;

import org.animal_api.db.entities.CowsEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CowsRepository extends NameRepository<CowsEntity>, AdvancedRepository<CowsEntity> {


}
