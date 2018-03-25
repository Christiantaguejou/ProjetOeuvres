package com.epul.oeuvres.dao;

import javax.persistence.*;

/**
 * Created by Valentin on 06/04/2016.
 */
public abstract class EntityService {

    protected EntityManager entitymanager;
    protected EntityManagerFactory emf;

    public EntityTransaction startTransaction() throws Exception
    {
        emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        entitymanager = emf.createEntityManager();

        return entitymanager.getTransaction();
    }

}