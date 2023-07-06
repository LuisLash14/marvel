package org.acme;

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
    public MarvelDto getPersonajes() {
        return service.getPersonajes();
    } 
        
}
