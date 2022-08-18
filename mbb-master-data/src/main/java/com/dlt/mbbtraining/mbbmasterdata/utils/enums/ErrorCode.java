package com.dlt.mbbtraining.mbbmasterdata.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Amir
 */

@Getter
@AllArgsConstructor
public enum ErrorCode {

    CODE_00("SUCCESSFULLY RETRIEVED"),
    CODE_01("MISSING USER DATA"),
    CODE_02("INTERNAL SYSTEM ERROR"),
    CODE_03("MISSING TRANSACTION DATA"),
    CODE_04("REQUEST BODY IS MISSING"),
    CODE_05("DATA NOT FOUND"),
    CODE_06("DUPLICATE DATA"),
    CODE_07("SUCCESSFULLY CREATE NEW USER");

    private String name;

}
