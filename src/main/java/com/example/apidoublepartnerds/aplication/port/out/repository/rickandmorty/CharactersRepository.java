package com.example.apidoublepartnerds.aplication.port.out.repository.rickandmorty;

import com.example.apidoublepartnerds.aplication.entities.ricandmorty.ResponseCharacter;
import feign.Headers;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Characters", url = "${rickandmorty.baseurl}")
public interface CharactersRepository {

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GetMapping(value = "/character?page={page}")
    ResponseCharacter retrieveCharacters(@PathVariable(value = "page") int page);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GetMapping(value = "/character/?name={name}")
    ResponseCharacter retrieveSingleCharacter(@PathVariable(value = "name") String name);
}
