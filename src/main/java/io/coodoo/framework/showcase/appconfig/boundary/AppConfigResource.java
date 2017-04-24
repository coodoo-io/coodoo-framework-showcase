package io.coodoo.framework.showcase.appconfig.boundary;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Rest resource to demonstrate the usage of <strong>coodoo-app-config</strong>
 * 
 * @author coodoo GmbH (coodoo.io)
 */
@Stateless
@Path("/appconfig")
public class AppConfigResource {

    @Inject
    AppConfigService appConfigService;

    @GET
    @Path("/do-important-things")
    public Response doImportantThings() {

        // http://localhost:8080/showcase/api/appconfig/do-important-things

        appConfigService.doImportantThings();

        return Response.ok("Important things done, see log!").build();
    }

    @GET
    @Path("/tell-me-a-secret")
    public Response tellMeASecret() {

        // http://localhost:8080/showcase/api/appconfig/tell-me-a-secret

        appConfigService.tellMeASecret();

        return Response.ok("Secret was told, see log!").build();
    }

}
