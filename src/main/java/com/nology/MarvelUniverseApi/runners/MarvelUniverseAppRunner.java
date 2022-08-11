package com.nology.MarvelUniverseApi.runners;
import com.nology.MarvelUniverseApi.services.MarvelUniverseCharacterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MarvelUniverseAppRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(MarvelUniverseAppRunner.class);

    private final MarvelUniverseCharacterService marvelUniverseCharacterService;

    public MarvelUniverseAppRunner(MarvelUniverseCharacterService marvelUniverseCharacterService) {
        this.marvelUniverseCharacterService = marvelUniverseCharacterService;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Loading characters from Marvel Api");
        marvelUniverseCharacterService.getCharacters().subscribe();
    }
}
