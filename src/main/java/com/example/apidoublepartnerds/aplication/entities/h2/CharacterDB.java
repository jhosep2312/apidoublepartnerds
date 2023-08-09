package com.example.apidoublepartnerds.aplication.entities.h2;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;


@Data
@Entity
@Table(name = "characters")
public class CharacterDB {
    public CharacterDB(Long characterId, String characterName, String characterGender, String characterImage, String characterStatus) {
        this.characterId = characterId;
        this.characterName = characterName;
        this.characterGender = characterGender;
        this.characterImage = characterImage;
        this.characterStatus = characterStatus;
    }

    CharacterDB(){

    }

    @Id
    private Long characterId;

    private String characterName;
    private String characterGender;
    private String characterImage;
    private String characterStatus;


}
