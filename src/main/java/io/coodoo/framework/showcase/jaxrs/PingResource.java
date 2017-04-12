package io.coodoo.framework.showcase.jaxrs;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.coodoo.framework.showcase.data.InitDataService;

@Stateless
@Path("/ping")
public class PingResource {

    private static Logger log = LoggerFactory.getLogger(PingResource.class);

    @Inject
    InitDataService initDataService;

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        log.info("ping");

        // kill me!
        initDataService.init();

        return "pong";
    }
}
