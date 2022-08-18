package com.dlt.mbbtraining.mbbmasterdata.controllers.response;

import com.dlt.mbbtraining.mbbmasterdata.utils.enums.AddressType;
import com.dlt.mbbtraining.mbbmasterdata.utils.enums.IdType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Amir on 12/5/2019 12:12 PM
 */

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    @NotNull
    @JsonProperty(value = "first_name")
    private String firstName;

    @JsonIgnore
    @JsonProperty(value = "middle_name")
    private String middleName;

    @JsonProperty(value = "last_name")
    private String lastName;

    @NotNull
    @JsonProperty(value = "age")
    private Integer age;

    @NotNull
    @JsonProperty(value = "id_type")
    private IdType idType;

    @NotNull
    @JsonProperty(value = "id_no")
    private String idNo;

    @JsonProperty(value = "addresses")
    private Set<AddressResponse> addressList;


    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AddressResponse {

        @JsonProperty(value = "address_1")
        private String address1;

        @JsonProperty(value = "address_2")
        private String address2;

        @JsonProperty(value = "postal_code")
        private String postalCode;

        @JsonProperty(value = "district")
        private String district;

        @JsonProperty(value = "state")
        private String state;

        @JsonProperty(value = "address_type")
        private AddressType addressType;

    }


}

