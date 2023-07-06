package org.acme;
import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.vertx.core.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import jakarta.ws.rs.QueryParam;


@RegisterRestClient(baseUri = "https://gateway.marvel.com:443/v1/public/characters?")
public interface MarvelApiClient {

    @GET
    @Path("")
    JsonObject getList(
        @QueryParam("ts") long timestamp,
        @QueryParam("apikey") String apikey,
        @QueryParam("hash") String hash 
    );

    @GET
    @Path("")
    JsonObject getByName(
        @QueryParam("name") String name,
        @QueryParam("ts") long timestamp,
        @QueryParam("apikey") String apikey,
        @QueryParam("hash") String hash 
    );
}

