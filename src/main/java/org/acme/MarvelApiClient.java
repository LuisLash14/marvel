package org.acme;
import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import jakarta.ws.rs.QueryParam;


@RegisterRestClient(baseUri = "https://gateway.marvel.com:443/v1/public/characters/1017100?")
public interface MarvelApiClient {

    @GET
    @Path("")
    Object GET(
        @QueryParam("ts") long timestamp,
        @QueryParam("apikey") String apikey,
        @QueryParam("hash") String hash 
    );

}

