package com.dlt.mbbtraining.mbbmasterdata.controllers.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * Created by Amir on 12/5/2019 12:12 PM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionStatusRequest {

    @NotNull
    @JsonProperty(value = "code")
    private String code;

    @NotNull
    @JsonProperty(value = "value")
    private String value;

}
