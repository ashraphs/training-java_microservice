package com.dlt.mbbtraining.mbbmasterdata.services;

import com.dlt.mbbtraining.mbbmasterdata.controllers.request.NewUserRequest;
import com.dlt.mbbtraining.mbbmasterdata.controllers.request.UserRequest;
import com.dlt.mbbtraining.mbbmasterdata.controllers.response.UserResponse;
import com.dlt.mbbtraining.mbbmasterdata.utils.CustomException;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * @author Amir
 */
public interface UserService {

    UserResponse getUser(UserRequest request) throws CustomException, InvocationTargetException, IllegalAccessException;

    UserResponse createNewUser(NewUserRequest request) throws CustomException, InvocationTargetException, IllegalAccessException, SQLException;

    UserResponse updateUser(UserRequest request);

    void deactivateUser(UserRequest request);

}
