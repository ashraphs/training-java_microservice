package com.dlt.mbbtraining.mbbmasterdata.controllers;

import com.dlt.mbbtraining.mbbmasterdata.controllers.request.NewUserRequest;
import com.dlt.mbbtraining.mbbmasterdata.controllers.request.UserRequest;
import com.dlt.mbbtraining.mbbmasterdata.controllers.response.MasterResponse;
import com.dlt.mbbtraining.mbbmasterdata.controllers.response.UserResponse;
import com.dlt.mbbtraining.mbbmasterdata.services.UserService;
import com.dlt.mbbtraining.mbbmasterdata.utils.GlobalUtil;
import com.dlt.mbbtraining.mbbmasterdata.utils.enums.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Amir on 12/4/2019 1:54 PM
 */

@Slf4j
@RestController
@RequestMapping(value = {"/user"})
public class CustomerUserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public MasterResponse getOneUser(@Valid @RequestBody UserRequest request) {
        try {
            UserResponse userResponse = userService.getUser(request);
            log.info("Response: {}", userResponse);

            return MasterResponse.builder()
                    .responseValue(HttpStatus.OK.value())
                    .message(ErrorCode.CODE_00.getName())
                    .currentTimestamp(GlobalUtil.currentMalaysiaTimestampIso8601())
                    .t(userResponse)
                    .build();

        } catch (Exception ex) {
            log.error("Error: {}", ex.getMessage());
            return MasterResponse.builder()
                    .responseValue(HttpStatus.BAD_REQUEST.value())
                    .message(ex.getMessage())
                    .currentTimestamp(GlobalUtil.currentMalaysiaTimestampIso8601())
                    .t(null)
                    .build();
        }
    }

    @PostMapping
    public MasterResponse<?> createNewUser(@RequestBody NewUserRequest request) {
        try {
            UserResponse userResponse = userService.createNewUser(request);
            log.info("Response: {}", userResponse);

            return MasterResponse.builder()
                    .responseValue(HttpStatus.CREATED.value())
                    .message(ErrorCode.CODE_07.getName())
                    .currentTimestamp(GlobalUtil.currentMalaysiaTimestampIso8601())
                    .t(userResponse)
                    .build();

        } catch (Exception ex) {
            log.error("Error: {}", ex.getMessage());
            return MasterResponse.builder()
                    .responseValue(HttpStatus.BAD_REQUEST.value())
                    .message(ex.getMessage())
                    .currentTimestamp(GlobalUtil.currentMalaysiaTimestampIso8601())
                    .t(null)
                    .build();
        }
    }
}



