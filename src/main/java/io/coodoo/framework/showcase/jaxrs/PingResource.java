package io.coodoo.framework.showcase.jaxrs;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
@Path("/ping")
public class PingResource {

    private static Logger log = LoggerFactory.getLogger(PingResource.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        log.info("ping");
        return "pong";
    }
}
