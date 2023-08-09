package com.example.apidoublepartnerds.aplication;

import com.example.apidoublepartnerds.aplication.entities.BaseResponseDto;
import com.example.apidoublepartnerds.aplication.port.in.CharactersService;
import com.example.apidoublepartnerds.aplication.port.out.CharacterH2DAO;
import com.example.apidoublepartnerds.aplication.port.out.CharactersDAO;
import com.example.apidoublepartnerds.aplication.port.out.repository.h2database.CharacterDBRepository;
import com.example.apidoublepartnerds.domain.Characters;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CharactersServiceHandler implements CharactersService {

    private final CharactersDAO repository;

    private final CharacterH2DAO repositoryHtwo;
    private final CharacterDBRepository characterDBRepository;

    public CharactersServiceHandler(CharactersDAO repository, CharacterH2DAO repositoryHtwo, CharacterDBRepository characterDBRepository) {
        this.repository = repository;
        this.repositoryHtwo = repositoryHtwo;
        this.characterDBRepository = characterDBRepository;
    }

    @Override
    public BaseResponseDto<Characters> getAllCharacters(int page) {

        log.debug("method: getAllCharacters({})");
        try {
            var characters = repository.retrieveAllCharacters(page);

            return new BaseResponseDto<Characters>().ok("success", characters);
        } catch (FeignException ex) {
            log.error("method: getAllCharacters() -> error -> {}", ex.getMessage(), ex);
            return new BaseResponseDto<Characters>().badRequest(ex.getMessage());
        }
    }

    @Override
    public BaseResponseDto<Characters> saveCharacter(String characterName) {
        log.debug("method: saveCharacter({})");
        try {
            var characters = repository.retrieveCharacterByName(characterName);

            if (characters.getResults().length > 1 &&
                    !characters.getResults()[0].getName().equalsIgnoreCase(characterName)) {
                    return new BaseResponseDto<Characters>().error("The character: "+ characterName+" does not match any in the API ");
            }
            if (characterDBRepository.existsById(Long.parseLong(characters.getResults()[0].getId() + ""))) {
                return new BaseResponseDto<Characters>().error("the character : " + characterName + " already exists");
            }

            repositoryHtwo.saveCharacterH2(characters.getResults()[0] );

            return new BaseResponseDto<Characters>().ok("Save Character success", null);
        } catch (FeignException ex) {
           if(ex.getClass().toString().equals("class feign.FeignException$NotFound")){
               return new BaseResponseDto<Characters>().error("The character: "+ characterName+" does not match any in the API ");
           }
            log.error("method: saveCharacter() -> error -> {}", ex.getMessage(), ex.getClass());
            return new BaseResponseDto<Characters>().badRequest(ex.getMessage());
        }

    }
}
