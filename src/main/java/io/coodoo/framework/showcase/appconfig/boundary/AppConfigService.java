package io.coodoo.framework.showcase.appconfig.boundary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.coodoo.framework.appconfig.boundary.AppConfigs;
import io.coodoo.framework.appconfig.entity.AppConfigValue;

@Stateless
public class AppConfigService {

    private static Logger log = LoggerFactory.getLogger(AppConfigService.class);

    @Inject
    AppConfigs appConfigs;

    @PersistenceContext
    private EntityManager entityManager;

    public void doImportantThings() {

        if (appConfigs.getNativeBoolean(AppConfig.IMPORTANT_THINGS_ACTIVE)) {

            log.info("Important things are active!");

            for (Long id : appConfigs.getLongList(AppConfig.IMPORTANT_THINGS)) {

                log.info("Important thing wiht ID {}", id);

            }

            appConfigs.setBoolean(AppConfig.IMPORTANT_THINGS_ACTIVE, false);
            log.info("Important things set to be not active!");

        } else {

            log.info("Important things are not active!");

            List<Long> importantThings = createImportantThings();

            appConfigs.setLongList(AppConfig.IMPORTANT_THINGS, importantThings);
            log.info("created new important things: {}", importantThings);

            appConfigs.setBoolean(AppConfig.IMPORTANT_THINGS_ACTIVE, true);
            log.info("Important things set to be active!");
        }
    }

    private List<Long> createImportantThings() {
        List<Long> importantThings = new ArrayList<>();
        Random random = new Random();
        IntStream.rangeClosed(1, random.nextInt((8 - 3) + 1) + 3).forEach(e -> importantThings.add(random.nextLong()));
        return importantThings;
    }

    public void tellMeASecret() {

        String secret = "I like owls!";

        appConfigs.setString(AppConfig.SECRET, secret);
        log.info("Secret is stored in database.");

        hackHackHack();

        log.info("He can't know, but the secret was \"{}\".", appConfigs.getString(AppConfig.SECRET));
    }

    private void hackHackHack() {

        log.warn("Oh no, a hacker got into the database!");

        AppConfigValue databaseLeak = entityManager.find(AppConfigValue.class, "SECRET");
        log.info("He stole the secret: {}", databaseLeak.getValue());
    }

}
