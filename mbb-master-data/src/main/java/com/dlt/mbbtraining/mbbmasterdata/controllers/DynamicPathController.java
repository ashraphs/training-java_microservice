package com.dlt.mbbtraining.mbbmasterdata.controllers;

import com.dlt.mbbtraining.mbbmasterdata.controllers.response.MasterResponse;
import com.dlt.mbbtraining.mbbmasterdata.services.UserService;
import com.dlt.mbbtraining.mbbmasterdata.utils.GlobalUtil;
import com.dlt.mbbtraining.mbbmasterdata.utils.enums.EnvironmentRegion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Amir on 12/4/2019 1:54 PM
 */

@Slf4j
@RestController
@RequestMapping(value = {"/casaTransaction"})
public class DynamicPathController {

    @Autowired
    private UserService userService;

    /**
     * @param environment whether its running from internal or external
     * @return the Masterresponse
     */
    @GetMapping(path = "{environment}")
    public MasterResponse<?> getSamplePath(@RequestBody String environment) {
        String envPath = GlobalUtil.removeWhiteSpaceAndMakeitCapital(environment);
        String response = "";

        switch (envPath) {
            case "INTERNAL":
                response = "Running from INTERNAL path";
                break;

            case "EXTERNAL":
                response = "Running from EXTERNAL path";
                break;
        }

        return MasterResponse.builder()
                .responseValue(HttpStatus.OK.value())
                .message(null)
                .currentTimestamp(GlobalUtil.currentMalaysiaTimestampIso8601())
                .t(response)
                .build();

    }

    /**
     * Sample 1: http://localhost:8082/casaTransaction/internal/region/sg2ubiz/api/v1.0
     * Sample 2: http://localhost:8082/casaTransaction/internal/region/sg2ubiz/api/v1.0
     * RESULT: WE DONT CARE THE PATH AFTER <REGION/**>
     * INTEGRATION IDEA: WE CAN USE RESTTEMPLATE, WEB FLUX OR FEIGN CLIENT TO CONNECT TO REGION API
     *
     * @param request
     * @return
     */
    @GetMapping(path = "/internal/region/**")
    public MasterResponse<?> dynamicSamplePath(HttpServletRequest request) {
        String requestPath = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        log.info("Full Path: {}", requestPath);

        String regionPath = new GlobalUtil().findRegionMatchAPiPath(requestPath);
        if (regionPath.equals(EnvironmentRegion.M2UBIZ.name())) {
            //  CODE TO HIT THE PATH OF MALAYSIA API

        } else if (regionPath.equals(EnvironmentRegion.SG2UBIZ.name())) {
            //  CODE TO HIT THE PATH OF SINGAPORE API

        }

        return MasterResponse.builder()
                .responseValue(HttpStatus.OK.value())
                .message(null)
                .currentTimestamp(GlobalUtil.currentMalaysiaTimestampIso8601())
                .t(regionPath)
                .build();

    }



}



