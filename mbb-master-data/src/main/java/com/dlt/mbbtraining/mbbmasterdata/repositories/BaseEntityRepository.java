package com.dlt.mbbtraining.mbbmasterdata.repositories;

import com.dlt.mbbtraining.mbbmasterdata.entities.base.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface BaseEntityRepository<T extends BaseEntity>
        extends JpaRepository<T, String>, JpaSpecificationExecutor<T> {
}
