package com.dlt.mbbtraining.mbbmasterdata.services.impl;

import com.dlt.mbbtraining.mbbmasterdata.entities.TransactionStatus;
import com.dlt.mbbtraining.mbbmasterdata.repositories.TransactionStatusCodeRepository;
import com.dlt.mbbtraining.mbbmasterdata.services.CacheService;
import com.dlt.mbbtraining.mbbmasterdata.utils.CustomException;
import com.dlt.mbbtraining.mbbmasterdata.utils.enums.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Amir
 */

@Slf4j
@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    private RedisTemplate<String, String> template;

    @Autowired
    private TransactionStatusCodeRepository statusCodeRepository;


    @Override
    public TransactionStatus getStatusCode(String code) throws CustomException {
        TransactionStatus status = new TransactionStatus();

        String cacheValue = template.opsForValue().get(code);
        if (cacheValue == null) {
            status = statusCodeRepository.findByCodeAndActiveIsTrueAndDeletedIsFalse(code);
            if (status != null) {
                template.opsForValue().set(status.getCode(), status.getValue());
            } else {
                throw new CustomException(ErrorCode.CODE_05.getName());
            }
        } else {
            status.setCode(code);
            status.setValue(cacheValue);
        }

        return status;
    }

    @Override
    public TransactionStatus updateStatusCode(String code) {
        return null;
    }

    @Override
    public TransactionStatus invalidateStatusCode(String code) {
        return null;
    }

    @Override
    public TransactionStatus removeStatusCode(String code) {
        return null;
    }


}
