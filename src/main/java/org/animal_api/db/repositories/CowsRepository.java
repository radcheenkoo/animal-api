package org.animal_api.db.repositories;

import org.animal_api.db.entities.CowsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CowsRepository extends JpaRepository<CowsEntity, Long> {

    CowsEntity getByName(String name);

}
