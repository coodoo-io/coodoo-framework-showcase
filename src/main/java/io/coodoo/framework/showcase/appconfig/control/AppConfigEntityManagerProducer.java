package io.coodoo.framework.showcase.appconfig.control;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.coodoo.framework.appconfig.boundary.annotation.AppConfigEntityManager;

@Stateless
public class AppConfigEntityManagerProducer {

    @PersistenceContext
    private EntityManager entityManager;

    @Produces
    @AppConfigEntityManager
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
