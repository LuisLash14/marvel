package org.acme;
import org.apache.commons.codec.digest.DigestUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MarvelService {
    @Inject
    @RestClient
    MarvelApiClient marvel;

    // Obtener el timestamp actual en milisegundos
        /* long timestamp = Instant.now().toEpochMilli();
        String ts = String.valueOf(timestamp); */
    // Claves pública y privada
        @ConfigProperty(name = "publicKey")
        String publicKey;

        @ConfigProperty(name = "privateKey")
        String privateKey;

    
    public MarvelDto getPersonajes(){
        String input = "1" + privateKey + publicKey;
        String hash = DigestUtils.md5Hex(input);
        System.out.println("Datos: "+"1" + publicKey+ "--"+ hash);

        MarvelDto result = marvel.Characters(1 , publicKey, hash);
        
        System.out.println(result.getPersonajes());
        return result; 
    }

}
