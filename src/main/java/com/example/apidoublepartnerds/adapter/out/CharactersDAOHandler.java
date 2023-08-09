package com.example.apidoublepartnerds.adapter.out;

import com.example.apidoublepartnerds.aplication.entities.ricandmorty.ResponseCharacter;
import com.example.apidoublepartnerds.aplication.mappers.CharactersMapper;
import com.example.apidoublepartnerds.aplication.port.out.CharactersDAO;
import com.example.apidoublepartnerds.aplication.port.out.repository.rickandmorty.CharactersRepository;
import com.example.apidoublepartnerds.domain.Characters;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class CharactersDAOHandler implements CharactersDAO {

    private final CharactersRepository charactersRepository;
    final CharactersMapper mapper;

    public CharactersDAOHandler(CharactersRepository charactersRepository, CharactersMapper mapper) {
        this.charactersRepository = charactersRepository;
        this.mapper = mapper;
    }


    @Override
    public Characters retrieveAllCharacters(int page) {

        log.debug("method: retrieveOrderDetails({})");
        var characters = charactersRepository.retrieveCharacters(page);
        log.debug("method: retrieveOrderDetails({}) -> order: {}", null, null);
        return mapper.toDomain(characters);

    }

    @Override
    public Characters retrieveCharacterByName(String characterName) {

        log.debug("method: retrieveOrderDetails({})");
        var characters = charactersRepository.retrieveSingleCharacter(characterName);
        log.debug("method: retrieveOrderDetails({}) -> order: {}", null, null);
        return mapper.toDomain(characters);
    }
}
