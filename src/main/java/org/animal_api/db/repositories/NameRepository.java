package org.animal_api.db.repositories;

import org.animal_api.db.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface NameRepository<E extends BaseEntity> extends JpaRepository<E, Long> {

    Optional<E> findByName(String name);

}
