package io.coodoo.framework.showcase.data;

import java.io.IOException;
import java.net.URL;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Singleton
@Startup
public class DataInitializationService {

    private static Logger log = LoggerFactory.getLogger(DataInitializationService.class);

    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void init() {

        try {

            ObjectMapper mapper = new ObjectMapper();

            URL resource = DataInitializationService.class.getClassLoader().getResource("Cars.json");
            log.info("Initialize data from {}", resource.toString());

            JsonNode jsonNode = mapper.readTree(resource);

            for (JsonNode carNode : jsonNode) {
                CarData car = mapper.convertValue(carNode, CarData.class);
                log.info("Write data to database: {}", car);
                entityManager.persist(car);
            }

        } catch (IOException e) {
            log.error("Can't initialize data: {}", e.getMessage());
        }

    }

}
