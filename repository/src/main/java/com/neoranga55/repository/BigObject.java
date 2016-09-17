package com.neoranga55.repository;

import java.util.ArrayList;

import javax.inject.Inject;

public class BigObject {

    private final ArrayList<String> mData;

    @Inject
    public BigObject() {
        mData = new ArrayList<>(500);
    }
}
