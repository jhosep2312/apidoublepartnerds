package com.example.apidoublepartnerds.aplication.mappers;

import com.example.apidoublepartnerds.aplication.entities.h2.CharacterDB;
import com.example.apidoublepartnerds.aplication.entities.ricandmorty.ResponseCharacter;
import com.example.apidoublepartnerds.domain.Characters;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;

@Component
public class CharactersMapper {

    public Characters toDomain(ResponseCharacter entity) {
        if (Objects.isNull(entity))
            return null;
        return Characters.builder()
                .info(entity.getInfo())
                .results(setResults(entity.getResults()))
                .build();
    }

    public CharacterDB toEntity(Characters.Results domain) {
        if (Objects.isNull(domain))
            return null;
        return new CharacterDB(
                Long.parseLong(domain.getId() + ""),
                domain.getName(),
                domain.getGender(),
                domain.getImage(),
                domain.getStatus());

    }


    private Characters.Results[] setResults(ResponseCharacter.Results[] results) {

        Characters.Results[] newList = new Characters.Results[results.length];

        for (int i = 0; i < results.length; i++) {
            newList[i] = Characters.Results.builder()
                    .id(results[i].getId())
                    .image(results[i].getImage())
                    .name(results[i].getName())
                    .gender(results[i].getGender())
                    .status(results[i].getStatus())
                    .build();
        }
        return newList;
    }
}
