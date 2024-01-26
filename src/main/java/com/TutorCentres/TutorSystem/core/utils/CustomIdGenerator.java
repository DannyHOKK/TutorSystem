package com.TutorCentres.TutorSystem.core.utils;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class CustomIdGenerator implements IdentifierGenerator {

    private static final String PREFIX = "T";

    private int counter = 0;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return PREFIX + String.format("%05d", ++counter);
    }
}