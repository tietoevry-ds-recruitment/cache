package com.tietoevry;

import com.tietoevry.dto.PersonDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/compute")
public class SlowResource {

    @Inject
    @RestClient
    ExternalService externalService;

    @GET
    @Path("/user/{userId}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response computeUser(@PathParam("userId") Long id) {
        String key = "[" + id + "]";

        var users = externalService.fetchAllUsers();
        if (users.isEmpty() || !users.get(0).containsKey(key)) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        PersonDTO user = users.get(0).get(key);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(user.firstName() + " " + user.surname()).build();
    }
}
