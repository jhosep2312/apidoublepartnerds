package com.example.apidoublepartnerds.adapter.out;

import com.example.apidoublepartnerds.aplication.mappers.CharactersMapper;
import com.example.apidoublepartnerds.aplication.port.out.CharacterH2DAO;
import com.example.apidoublepartnerds.aplication.port.out.repository.h2database.CharacterDBRepository;
import com.example.apidoublepartnerds.domain.Characters;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class CharacterH2DAOHandler implements CharacterH2DAO {

    private final CharacterDBRepository repository;
    private final CharactersMapper mapper;

    public CharacterH2DAOHandler(CharacterDBRepository repository, CharactersMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public boolean saveCharacterH2(Characters.Results result) {
        log.debug("method: saveCharacterH2({})");
        var characters = repository.save(mapper.toEntity(result));
        log.debug("method: saveCharacterH2({}) -> order: {}", null, null);
        return characters.getCharacterId() != null;
    }
}
