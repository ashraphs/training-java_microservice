package com.dlt.mbbtraining.mbbmasterdata.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Amir
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum EnvironmentRegion {

    SG2UBIZ("SINGAPORE"),
    /**
     *
     */
    M2UBIZ("MALAYSIA");


    private String description;

}
