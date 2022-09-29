package com.dlt.mbbtraining.mbbmasterdata.easyrules.model;

public enum Greeting {

    GOOD_MORNING("Good Morning"),
    GOOD_AFTERNOON("Good Afternoon"),
    GOOD_EVENING("Good Evening"),
    GOOD_NIGHT("Good Night");

    private final String literal;

    private Greeting(final String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }

}