package org.animal_api.db.repositories;

import org.animal_api.db.entities.GoatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GoatsRepository extends JpaRepository<GoatsEntity, Long> {

    GoatsEntity getByName(String name);

}
