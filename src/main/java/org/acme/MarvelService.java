package org.acme;
import java.time.Instant;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.vertx.core.json.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MarvelService {
    @Inject
    @RestClient
    MarvelApiClient marvel;

    // Obtener el timestamp actual en milisegundos
        long timestamp = Instant.now().toEpochMilli();
        String ts = String.valueOf(timestamp); 
    // Claves pública y privada
        @ConfigProperty(name = "publicKey")
        String publicKey;

        @ConfigProperty(name = "privateKey")
        String privateKey;

    
    public JsonObject getPersonajes(){
        String input = ts + privateKey + publicKey;
        String hash = DigestUtils.md5Hex(input);
        return marvel.GET(timestamp , publicKey, hash);
    }

}
