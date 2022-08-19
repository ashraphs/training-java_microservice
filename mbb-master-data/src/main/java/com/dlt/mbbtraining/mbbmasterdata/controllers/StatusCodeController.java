package com.dlt.mbbtraining.mbbmasterdata.controllers;

import com.dlt.mbbtraining.mbbmasterdata.controllers.response.MasterResponse;
import com.dlt.mbbtraining.mbbmasterdata.entities.TransactionStatus;
import com.dlt.mbbtraining.mbbmasterdata.services.CacheService;
import com.dlt.mbbtraining.mbbmasterdata.utils.CustomException;
import com.dlt.mbbtraining.mbbmasterdata.utils.GlobalUtil;
import com.dlt.mbbtraining.mbbmasterdata.utils.enums.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * Created by Amir on 12/4/2019 1:54 PM
 */

@Slf4j
@RestController
@RequestMapping(value = {"/transaction-status-code"})
public class StatusCodeController {

    @Autowired
    private CacheService cacheService;


    /**
     * GET ONE TRANSACTION STATUS
     *
     * @param code of status that need to be parse into the controller
     * @return the data from redis cache primary or DB as secondary storage
     */
    @GetMapping
    public MasterResponse getOneTransactionStatusCode(@NotNull @RequestParam final String code) throws CustomException {
        try {
            TransactionStatus status = cacheService.getStatusCode(code);

            return MasterResponse.builder()
                    .responseValue(HttpStatus.OK.value())
                    .message(ErrorCode.CODE_00.getName())
                    .currentTimestamp(GlobalUtil.currentMalaysiaTimestampIso8601())
                    .t(status)
                    .build();


        } catch (Exception ex) {
            return MasterResponse.builder()
                    .responseValue(HttpStatus.CREATED.value())
                    .message(ErrorCode.CODE_07.getName())
                    .currentTimestamp(GlobalUtil.currentMalaysiaTimestampIso8601())
                    .t(ex.getMessage())
                    .build();
        }
    }

}
