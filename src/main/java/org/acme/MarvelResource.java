package org.acme;

import java.util.List;

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
    public Object getPersonajes() {
        return service.getPersonajes();
    } 
        
}
