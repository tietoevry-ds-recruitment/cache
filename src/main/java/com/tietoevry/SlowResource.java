package com.tietoevry;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;


@Path("/compute")
public class SlowResource {

    @Inject
    @RestClient
    ExternalService externalService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String compute() {
        return externalService.callMeMaybe(5);
    }
}
