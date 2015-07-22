package com.mikalai.j2ee.ejb;


import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



public class DatabaseProducer {


    @Produces
    @PersistenceContext(unitName = "chapter08PU")
    private EntityManager em;
}
