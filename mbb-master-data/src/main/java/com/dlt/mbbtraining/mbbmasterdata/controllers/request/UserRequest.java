package com.dlt.mbbtraining.mbbmasterdata.controllers.request;

import com.dlt.mbbtraining.mbbmasterdata.utils.enums.IdType;
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
public class UserRequest {

    @NotNull
    @JsonProperty(value = "id_type")
    private IdType idType;

    @NotNull
    @JsonProperty(value = "id_no")
    private String idNo;


}
