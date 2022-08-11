package com.nology.MarvelUniverseApi.controllers;

import com.nology.MarvelUniverseApi.models.MarvelUniverseCharacter;
import com.nology.MarvelUniverseApi.services.MarvelUniverseCharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping
public class MarvelUniverseCharacterController {

    MarvelUniverseCharacterService charactersService;

    public MarvelUniverseCharacterController(MarvelUniverseCharacterService charactersService) {
        this.charactersService = charactersService;
    }

    @GetMapping("/characters")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Flux<List<MarvelUniverseCharacter>> getCharacters() {
        return charactersService.getCharacters();
    }

    @GetMapping("/characters/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<List<MarvelUniverseCharacter>> getCharacter(@PathVariable int id) {
        return charactersService.getCharacterById(id);
    }
}
