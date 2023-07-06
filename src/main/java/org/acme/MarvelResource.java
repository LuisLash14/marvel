package org.acme;

import java.util.List;

import io.vertx.core.json.JsonObject;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/list")
public class MarvelResource {
    @Inject
    MarvelService service;

    @Path("")
    @GET
    public JsonObject getPersonajes() {
        return service.getPersonajes();
    } 
        
}
