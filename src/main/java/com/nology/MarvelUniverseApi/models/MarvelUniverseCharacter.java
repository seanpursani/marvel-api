package com.nology.MarvelUniverseApi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarvelUniverseCharacter {

    private Long id;
    private String name;
    private String description;
    @JsonProperty("thumbnail")
    private MarvelUniverseCharacterThumbnail marvelThumbnail;

}