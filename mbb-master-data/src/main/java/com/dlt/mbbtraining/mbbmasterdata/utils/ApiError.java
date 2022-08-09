package com.dlt.mbbtraining.mbbmasterdata.utils;

/**
 * Created by Amir on 12/4/2019 2:01 PM
 */

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
public class ApiError {
    private String error;
    private Integer status;
    private String message;
    private Date timestamp;

    public ApiError(HttpStatus httpStatus, String message) {
        super();
        this.error = httpStatus.getReasonPhrase();
        this.status = httpStatus.value();
        this.message = message;
        this.timestamp = new Date();
    }

    public Date getTimestamp() {
        return timestamp != null ? (Date) timestamp.clone() : null;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp != null ? (Date) timestamp.clone() : null;
    }

}
