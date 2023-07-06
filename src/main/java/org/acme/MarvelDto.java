package org.acme;

import java.util.List;

public class MarvelDto {
    private List<MarvelCharacter> personajes;

    public MarvelDto() {
    }

    public MarvelDto(List<MarvelCharacter> personajes) {
        this.personajes = personajes;
    }

    public List<MarvelCharacter> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(List<MarvelCharacter> personajes) {
        this.personajes = personajes;
    }

}
