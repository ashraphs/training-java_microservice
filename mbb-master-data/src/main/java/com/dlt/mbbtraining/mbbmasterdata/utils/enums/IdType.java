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
public enum IdType {

    IC("IC"),
    /**
     *
     */
    PASSPORT("PASSPORT"),
    /**
     *
     */
    OTHERS("OTHERS");

    private String description;

}
