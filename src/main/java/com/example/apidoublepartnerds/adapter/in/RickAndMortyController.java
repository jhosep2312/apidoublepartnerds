package com.example.apidoublepartnerds.adapter.in;

import com.example.apidoublepartnerds.aplication.entities.BaseResponseDto;
import com.example.apidoublepartnerds.aplication.port.in.CharactersService;
import com.example.apidoublepartnerds.domain.Characters;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.apidoublepartnerds.utils.APIResponse.buildHttpResponse;

@Slf4j
@RestController
@RequestMapping("/apirickandmorty")
public class RickAndMortyController {


    private final CharactersService service;

    public RickAndMortyController(CharactersService service) {
        this.service = service;
    }

    @GetMapping("/get-all-characters")
    @ResponseBody
    public ResponseEntity<BaseResponseDto<Characters>> getAllCharacters(@RequestParam(defaultValue = "1")  int page) {
        log.debug("method: getAllCharacters()");
        final BaseResponseDto<Characters> responseEntity = service.getAllCharacters(page);
        log.debug("method: getAllCharacters() -> {}", responseEntity);
        return buildHttpResponse(responseEntity);
    }

    @GetMapping("/save-character/{characterName}")
    @ResponseBody
    public ResponseEntity<BaseResponseDto<Characters>> saveCharacters(@PathVariable String characterName) {
        log.debug("method: saveCharacters()");
        final BaseResponseDto<Characters> responseEntity = service.saveCharacter(characterName);
        log.debug("method: saveCharacters() -> {}", responseEntity);
        return buildHttpResponse(responseEntity);
    }

}
