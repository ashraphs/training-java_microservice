package com.dlt.mbbtraining.mbbmasterdata.repositories;


import com.dlt.mbbtraining.mbbmasterdata.entities.SystemConfiguration;

/**
 * Created by Amir on 12/4/2019 12:55 PM
 */

public interface SystemConfigRepository extends MasterEntityRepository<SystemConfiguration> {

    SystemConfiguration findByNameAndActiveIsTrueAndDeletedIsFalse(String name);

}
