package org.acme;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.vertx.core.json.JsonArray;
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

    
    public List<HashMap<String, Object>> getList(){
        String input = ts + privateKey + publicKey;
        String hash = DigestUtils.md5Hex(input);
        JsonObject response = marvel.getList(timestamp, publicKey, hash);
        JsonArray results = response.getJsonObject("data").getJsonArray("results");

        List<HashMap<String, Object>> personajes = new ArrayList<>();

        for (int i = 0; i < results.size(); i++) {
            JsonObject jsonObject = results.getJsonObject(i);
            Integer id = jsonObject.getInteger("id");
            String name = jsonObject.getString("name");

            HashMap<String, Object> personaje = new HashMap<>();
            personaje.put("id", id);
            personaje.put("name", name);

            personajes.add(personaje);
        }
        return personajes;
    }

    public JsonObject getByName(String name){ 
        String input = ts + privateKey + publicKey;
        String hash = DigestUtils.md5Hex(input);
        JsonObject response = marvel.getByName(name,timestamp, publicKey, hash);
        return response;
    }

}
