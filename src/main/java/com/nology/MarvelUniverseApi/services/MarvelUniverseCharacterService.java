package com.nology.MarvelUniverseApi.services;

import com.nology.MarvelUniverseApi.models.MarvelUniverseCharacter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.sql.Timestamp;
import java.util.List;

@Service
public class MarvelUniverseCharacterService {
    @Value("${marvelApiPublicKey}")
    public String publicKey;
    @Value("${marvelApiPrivateKey}")
    public String privateKey;
    private final Timestamp ts = new Timestamp(System.currentTimeMillis());
    private final WebClient webClient;

    public MarvelUniverseCharacterService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://gateway.marvel.com/v1/public").build();
    }

    @Cacheable("characters")
    public Flux<List<MarvelUniverseCharacter>> getCharacters() {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/characters")
                        .queryParam("ts", ts)
                        .queryParam("apikey", publicKey)
                        .queryParam("hash", MD5HashService.getMD5Hash(ts, privateKey, publicKey))
                        .build())
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<List<MarvelUniverseCharacter>>() {})
                .cache()
                .retryWhen(Retry.max(3));
    }

    public Mono<List<MarvelUniverseCharacter>> getCharacterById(int id) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/characters" + id)
                        .queryParam("ts", ts)
                        .queryParam("apikey", publicKey)
                        .queryParam("hash", MD5HashService.getMD5Hash(ts, privateKey, publicKey))
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<MarvelUniverseCharacter>>() {})
                .retryWhen(Retry.max(3));
    }
}

