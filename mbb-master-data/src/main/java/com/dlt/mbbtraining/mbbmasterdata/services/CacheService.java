package com.dlt.mbbtraining.mbbmasterdata.services;

import com.dlt.mbbtraining.mbbmasterdata.entities.TransactionStatus;
import com.dlt.mbbtraining.mbbmasterdata.utils.CustomException;

/**
 * @author Amir
 */
public interface CacheService {


    TransactionStatus getStatusCode(String code) throws CustomException;

    TransactionStatus updateStatusCode(String code);

    TransactionStatus invalidateStatusCode(String code);

    TransactionStatus removeStatusCode(String code);
}
