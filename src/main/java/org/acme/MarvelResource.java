package org.acme;

import java.util.HashMap;
import java.util.List;

import io.vertx.core.json.JsonObject;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/Personajes")
public class MarvelResource {
    @Inject
    MarvelService service;

    @Path("/list")
    @GET
    public List<HashMap<String, Object>> getList() {
        return service.getList();
    } 
    
    @Path("/byName")
    @GET
    public JsonObject getByName(@QueryParam("name") String name) {
        return service.getByName(name);
    } 
}
