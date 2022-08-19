package com.dlt.mbbtraining.mbbmasterdata.repositories;

import com.dlt.mbbtraining.mbbmasterdata.entities.TransactionStatus;

/**
 * Created by Amir on 12/4/2019 12:55 PM
 */

public interface TransactionStatusCodeRepository extends MasterEntityRepository<TransactionStatus> {

    TransactionStatus findByCodeAndActiveIsTrueAndDeletedIsFalse(String code);


}