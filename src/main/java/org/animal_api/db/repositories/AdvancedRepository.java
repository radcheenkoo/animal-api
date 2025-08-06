package org.animal_api.db.repositories;

import org.animal_api.db.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface AdvancedRepository <E extends BaseEntity> extends JpaRepository<E, Long> {

}
