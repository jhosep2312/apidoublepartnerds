package com.example.apidoublepartnerds.aplication.port.in;

import com.example.apidoublepartnerds.aplication.entities.BaseResponseDto;
import com.example.apidoublepartnerds.domain.Characters;

public interface CharactersService {

    BaseResponseDto<Characters> getAllCharacters(int page);
    BaseResponseDto<Characters> saveCharacter(String characterName);
}
