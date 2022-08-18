package com.dlt.mbbtraining.mbbmasterdata.repositories;

import com.dlt.mbbtraining.mbbmasterdata.entities.User;

import javax.validation.constraints.NotNull;

/**
 * Created by Amir on 12/4/2019 12:55 PM
 */

public interface UserRepository extends MasterEntityRepository<User> {

    User findByIdNoAndActiveIsTrueAndDeletedFalse(@NotNull String idNo);

}