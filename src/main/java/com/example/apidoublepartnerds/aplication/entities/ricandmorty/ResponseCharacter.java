package com.example.apidoublepartnerds.aplication.entities.ricandmorty;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ResponseCharacter {

    private Info info;
    private Results[] results;
    private String error;

    @Data
    @Builder
    public static class Info {

        private int count;
        private int pages;
        private String next;
        private String prev;

    }

    @Data
    @Builder
    public static class Results {

        int id;
        String name;
        String status;
        String species;
        String type;
        String gender;
        Origin origin;
        Location location;
        String image;
        List<String> episode;
        String url;
        String created;
        @Data
        @Builder
        public static class Origin {
            String name;
            String url;
        }
        @Data
        @Builder
        public static class Location {
            String name;
            String url;
        }

    }

}
