package com.example.apidoublepartnerds.domain;

import com.example.apidoublepartnerds.aplication.entities.ricandmorty.ResponseCharacter;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Characters {

    private ResponseCharacter.Info info;
    private Results[] results;

    @Data
    @Builder
    public static class Results {
        private int id;
        private String image;
        private String name ;
        private String gender;
        private String status;
    }

}
