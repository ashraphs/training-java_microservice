package com.dlt.mbbtraining.mbbmasterdata.services.impl;

import com.dlt.mbbtraining.mbbmasterdata.controllers.request.NewUserRequest;
import com.dlt.mbbtraining.mbbmasterdata.controllers.request.UserRequest;
import com.dlt.mbbtraining.mbbmasterdata.controllers.response.UserResponse;
import com.dlt.mbbtraining.mbbmasterdata.entities.Address;
import com.dlt.mbbtraining.mbbmasterdata.entities.User;
import com.dlt.mbbtraining.mbbmasterdata.repositories.AddressRepository;
import com.dlt.mbbtraining.mbbmasterdata.repositories.UserRepository;
import com.dlt.mbbtraining.mbbmasterdata.services.UserService;
import com.dlt.mbbtraining.mbbmasterdata.utils.CustomException;
import com.dlt.mbbtraining.mbbmasterdata.utils.GlobalUtil;
import com.dlt.mbbtraining.mbbmasterdata.utils.enums.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author Amir
 */


@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public UserResponse getUser(UserRequest request) throws CustomException, InvocationTargetException, IllegalAccessException {
        UserResponse response;
        Set<UserResponse.AddressResponse> addressResponseList = new HashSet<>();

        if (!request.getIdNo().equals("")) {
            String idNo = GlobalUtil.removeWhiteSpaceAndMakeitCapital(request.getIdNo());

            User user = userRepository.findByIdNoAndActiveIsTrueAndDeletedFalse(idNo);
            log.info("User: {}", user);
            if (user != null) {

                user.getAddress().forEach(x -> {
                    UserResponse.AddressResponse newAddress = UserResponse.AddressResponse.builder()
                            .address1(x.getAddress1())
                            .address2(x.getAddress2())
                            .postalCode(x.getPostalCode())
                            .district(x.getDistrict())
                            .state(x.getState())
                            .addressType(x.getAddressType())
                            .build();

                    addressResponseList.add(newAddress);
                });

                response = UserResponse.builder()
                        .firstName(user.getFirstName())
                        .middleName(user.getMiddleName())
                        .lastName(user.getLastName())
                        .age(user.getAge())
                        .idNo(user.getIdNo())
                        .idType(user.getIdType())
                        .addressList(addressResponseList)
                        .build();

            } else {
                throw new CustomException(ErrorCode.CODE_05.getName());
            }
        } else {
            log.error("Error: {}", ErrorCode.CODE_01.getName());
            throw new CustomException(ErrorCode.CODE_01.getName());
        }

        return response;
    }

    @Transactional
    @Override
    public UserResponse createNewUser(@NotNull NewUserRequest request) throws CustomException, InvocationTargetException, IllegalAccessException, SQLException {
        log.info("Request: {}", request);

        UserResponse response = null;
        Set<UserResponse.AddressResponse> addressResponseList = new HashSet<>();

        Optional<User> getUser = Optional.ofNullable(userRepository.findByIdNoAndActiveIsTrueAndDeletedFalse(request.getIdNo()));

        log.info("### Boolean Get user: {}", getUser);
        if (!getUser.isPresent()) {
            Set<Address> addressList = new HashSet<>();

            request.getAddress().forEach(x -> {
                Address newAddress = Address.builder()
                        .address1(x.getAddress1())
                        .address2(x.getAddress2())
                        .postalCode(x.getPostalCode())
                        .district(x.getDistrict())
                        .state(x.getState())
                        .addressType(x.getAddressType())
                        .build();

                addressList.add(newAddress);
            });

            User newUser = User.builder()
                    .firstName(request.getFirstName())
                    .middleName(request.getMiddleName())
                    .lastName(request.getLastName())
                    .age(request.getAge())
                    .idNo(request.getIdNo())
                    .idType(request.getIdType())
                    .address(addressList)
                    .build();

            User userSaved = userRepository.save(newUser);

            Optional<User> user = Optional.ofNullable(userRepository.findByIdNoAndActiveIsTrueAndDeletedFalse(userSaved.getIdNo()));
            if (user.isPresent()) {
                user.get().getAddress().forEach(y -> {
                    UserResponse.AddressResponse addressResponse = UserResponse.AddressResponse.builder()
                            .address1(y.getAddress1())
                            .address2(y.getAddress2())
                            .postalCode(y.getPostalCode())
                            .district(y.getDistrict())
                            .state(y.getState())
                            .build();

                    addressResponseList.add(addressResponse);

                });

                response = UserResponse.builder()
                        .firstName(user.get().getFirstName())
                        .middleName(user.get().getMiddleName())
                        .lastName(user.get().getLastName())
                        .age(user.get().getAge())
                        .idNo(user.get().getIdNo())
                        .idType(user.get().getIdType())
                        .addressList(addressResponseList)
                        .build();

            }

        } else {
            log.error("Error: {}", ErrorCode.CODE_06.getName());
            throw new CustomException(ErrorCode.CODE_06.getName());
        }

        return response;
    }


    @Override
    public UserResponse updateUser(UserRequest request) {
        return null;
    }

    @Override
    public void deactivateUser(UserRequest request) {
    }
}
