package com.example.apidoublepartnerds.aplication.port.out;

import com.example.apidoublepartnerds.domain.Characters;

public interface CharactersDAO {

    Characters retrieveAllCharacters(int page);
    Characters retrieveCharacterByName(String characterName);
}
