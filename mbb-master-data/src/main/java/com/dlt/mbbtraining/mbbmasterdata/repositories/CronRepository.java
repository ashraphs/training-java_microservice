package com.dlt.mbbtraining.mbbmasterdata.repositories;

import com.dlt.mbbtraining.mbbmasterdata.entities.Cron;

/**
 * Created by Amir on 12/4/2019 12:55 PM
 */

public interface CronRepository extends MasterEntityRepository<Cron> {

    Cron findByNameAndActiveIsTrueAndDeletedIsFalse(String name);
}