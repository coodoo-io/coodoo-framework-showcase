package io.coodoo.framework.showcase.data;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

@Singleton
@Startup
public class InitDataService {

    private static Logger log = LoggerFactory.getLogger(InitDataService.class);

    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void init() {

        try {

            ObjectMapper mapper = new ObjectMapper();
            List<String> list = new ArrayList<>();

            long start = LocalDate.of(2016, 1, 1).toEpochDay();
            long end = LocalDate.now().toEpochDay();

            for (String file : AutoUmweltliste.files) {

                URL resource = InitDataService.class.getClassLoader().getResource(file);
                log.info("Initialize data from {}", resource.toString());

                Path path = Paths.get(resource.toURI());
                list.addAll(Files.lines(path).map(String::trim).filter(line -> line.startsWith("{\"Index\"")).collect(Collectors.toList()));
            }
            for (String json : list) {

                AutoUmweltliste car = mapper.readValue(json, AutoUmweltliste.class);

                car.setId(null);
                car.setCreatedAt(LocalDateTime.of(LocalDate.ofEpochDay(ThreadLocalRandom.current().longs(start, end).findAny().getAsLong()), LocalTime.now()));
                if (ThreadLocalRandom.current().nextBoolean()) {
                    car.setUpdatedAt(car.getCreatedAt().plusMinutes(ThreadLocalRandom.current().longs(start, end).findAny().getAsLong()));
                }
                entityManager.persist(car);

                log.info("Write data to database: {}", car);
            }

        } catch (URISyntaxException | IOException e) {
            log.error("Can't initialize data: {}", e.getMessage());
        }

    }

}
