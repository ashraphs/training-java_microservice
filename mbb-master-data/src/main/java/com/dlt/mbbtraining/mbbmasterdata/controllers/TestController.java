package com.dlt.mbbtraining.mbbmasterdata.controllers;

import com.dlt.mbbtraining.mbbmasterdata.controllers.response.MasterResponse;
import com.dlt.mbbtraining.mbbmasterdata.utils.GlobalUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Amir on 12/4/2019 1:54 PM
 */

@Slf4j
@RestController
@RequestMapping(value = {"${api.env.region.base-url}"})
public class TestController {

    /**
     * DYNAMIC PATH USING SPEL
     * @param request of servlet
     * @return path of API
     */
    @RequestMapping(value = "${sample.test}")
    public MasterResponse<?> test2(HttpServletRequest request) {
        String requestPath = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        log.info("Full Path: {}", requestPath);

        return MasterResponse.builder()
                .responseValue(HttpStatus.OK.value())
                .message(null)
                .currentTimestamp(GlobalUtil.currentMalaysiaTimestampIso8601())
                .t(requestPath)
                .build();

    }

    /**
     * @param request
     * @return
     */
    @GetMapping
    public MasterResponse<?> test(HttpServletRequest request) {
        String requestPath = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        log.info("Full Path: {}", requestPath);

        return MasterResponse.builder()
                .responseValue(HttpStatus.OK.value())
                .message(null)
                .currentTimestamp(GlobalUtil.currentMalaysiaTimestampIso8601())
                .t(requestPath)
                .build();

    }

}



