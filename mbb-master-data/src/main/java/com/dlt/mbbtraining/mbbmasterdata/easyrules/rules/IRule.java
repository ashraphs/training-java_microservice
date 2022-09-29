package com.dlt.mbbtraining.mbbmasterdata.easyrules.rules;


import com.dlt.mbbtraining.mbbmasterdata.easyrules.model.Case;
import com.dlt.mbbtraining.mbbmasterdata.easyrules.model.User;

public interface IRule {
    void helloUser(final Case aCase, final Response response);
    User returnUser(final Case aCase, final Response response);
}