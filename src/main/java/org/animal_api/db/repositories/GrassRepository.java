package org.animal_api.db.repositories;

import org.animal_api.db.entities.GrassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrassRepository extends JpaRepository<Long, GrassEntity> {
}
