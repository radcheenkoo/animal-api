package org.animal_api.db.repositories;

import org.animal_api.db.entities.CowsEntity;
import org.animal_api.db.entities.LionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LionsRepository extends NameRepository<LionsEntity>, AdvancedRepository<LionsEntity> {

    LionsEntity getByName(String name);

}
