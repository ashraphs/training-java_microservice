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
public enum AddressType {

    HOME("HOME"),
    /**
     *
     */
    OFFICE("OFFICE");

    private String description;

}
