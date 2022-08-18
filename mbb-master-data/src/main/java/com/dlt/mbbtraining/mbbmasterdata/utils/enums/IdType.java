package com.dlt.mbbtraining.mbbmasterdata.utils.enums;

import lombok.*;

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
