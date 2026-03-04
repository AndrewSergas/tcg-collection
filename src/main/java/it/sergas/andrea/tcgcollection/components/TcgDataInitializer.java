package it.sergas.andrea.tcgcollection.components;

import it.sergas.andrea.tcgcollection.entities.BaseCard;
import it.sergas.andrea.tcgcollection.repositories.LorcanaCardRepository;
import it.sergas.andrea.tcgcollection.repositories.MagicCardRepository;
import it.sergas.andrea.tcgcollection.repositories.OnePieceCardRepository;
import it.sergas.andrea.tcgcollection.repositories.PokemonCardRepository;
import it.sergas.andrea.tcgcollection.repositories.YugiohCardRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.bson.types.ObjectId;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * Generic component for initializing TCG card data from JSON resources.
 */
@Slf4j
@Component
@Profile("!test")
@RequiredArgsConstructor
public class TcgDataInitializer {

    private final ObjectMapper objectMapper;
    private final MagicCardRepository magicRepo;
    private final YugiohCardRepository yugiohRepo;
    private final LorcanaCardRepository lorcanaRepo;
    private final PokemonCardRepository pokemonRepo;
    private final OnePieceCardRepository onePieceRepo;

    @PostConstruct
    public void init() {
        try {
            loadCollectionIfEmpty("data/magic-cards.json", magicRepo, new TypeReference<>() {});
            loadCollectionIfEmpty("data/yugioh-cards.json", yugiohRepo, new TypeReference<>() {});
            loadCollectionIfEmpty("data/lorcana-cards.json", lorcanaRepo, new TypeReference<>() {});
            loadCollectionIfEmpty("data/pokemon-cards.json", pokemonRepo, new TypeReference<>() {});
            loadCollectionIfEmpty("data/onepiece-cards.json", onePieceRepo, new TypeReference<>() {});
        } catch (final IOException e) {
            log.error("Failed to initialize TCG data: {}", e.getMessage(), e);
        }
    }

    private <T extends BaseCard> void loadCollectionIfEmpty(final String resourcePath,
                                                            final MongoRepository<T, ObjectId> repository,
                                                            final TypeReference<List<T>> typeReference)
            throws IOException {
        if (repository.count() == 0) {
            log.info("Loading data from {}", resourcePath);
            val inputStream = new ClassPathResource(resourcePath).getInputStream();
            val cards = objectMapper.readValue(inputStream, typeReference);
            repository.saveAll(cards);
        }
    }
}
