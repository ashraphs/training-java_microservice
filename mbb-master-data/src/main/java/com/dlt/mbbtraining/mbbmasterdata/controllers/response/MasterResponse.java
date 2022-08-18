package com.dlt.mbbtraining.mbbmasterdata.controllers.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Amir
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"response", "message", "current_timestamp", "data"})
public class MasterResponse<T> {

    @JsonProperty(value = "response")
    private int responseValue;

    @JsonProperty(value = "message")
    private String message;

    @JsonProperty(value = "current_timestamp")
    private String currentTimestamp;

    @JsonProperty(value = "data")
    private T t;
}
