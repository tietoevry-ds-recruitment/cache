package com.tietoevry;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/delay")
@RegisterRestClient (configKey = "external-api")
public interface ExternalService {

    @GET
    String callMeMaybe(@QueryParam("seconds") int seconds);
}
