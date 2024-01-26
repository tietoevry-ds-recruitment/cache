package com.tietoevry;

import com.tietoevry.dto.PersonDTO;
import jakarta.ws.rs.GET;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;
import java.util.Map;

@RegisterRestClient (configKey = "external-api")
public interface ExternalService {

    @GET
    List<Map<String, PersonDTO>> fetchAllUsers();
}
