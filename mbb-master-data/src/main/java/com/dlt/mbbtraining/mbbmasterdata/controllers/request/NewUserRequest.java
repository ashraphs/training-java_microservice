package com.dlt.mbbtraining.mbbmasterdata.controllers.request;

import com.dlt.mbbtraining.mbbmasterdata.utils.enums.AddressType;
import com.dlt.mbbtraining.mbbmasterdata.utils.enums.IdType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Amir on 12/5/2019 12:12 PM
 */

@Data
public class NewUserRequest {

    @Size(max = 64)
    @JsonProperty(value = "first_name")
    private String firstName;

    @Size(max = 64)
    @JsonProperty(value = "middle_name")
    private String middleName;

    @Size(max = 64)
    @JsonProperty(value = "last_name")
    private String lastName;

    @JsonProperty(value = "age")
    private Integer age;

    @JsonProperty(value = "id_type")
    private IdType idType;

    @Size(max = 15)
    @JsonProperty(value = "id_no")
    private String idNo;

    @JsonProperty(value = "address")
    private List<AddressRequest> address;

    @Data
    public static class AddressRequest {

        @Size(max = 100)
        @JsonProperty(value = "address_1")
        private String address1;

        @Size(max = 100)
        @JsonProperty(value = "address_2")
        private String address2;

        @Size(max = 10)
        @JsonProperty(value = "postal_code")
        private String postalCode;

        @Size(max = 15)
        @JsonProperty(value = "district")
        private String district;

        @Size(max = 15)
        @JsonProperty(value = "state")
        private String state;

        @Size(max = 10)
        @JsonProperty(value = "address_type")
        private AddressType addressType;
    }

}
