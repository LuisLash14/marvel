package org.acme;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import jakarta.ws.rs.QueryParam;


@RegisterRestClient(configKey="marvel-api")
public interface MarvelApiClient {

    @GET
    @Path("/v1/public/characters")
    MarvelDto Characters(
        @QueryParam("ts") long timestamp,
        @QueryParam("apikey") String apikey,
        @QueryParam("hash") String hash
    );

}

