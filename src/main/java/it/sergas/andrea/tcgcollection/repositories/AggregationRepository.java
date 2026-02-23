package it.sergas.andrea.tcgcollection.repositories;

import it.sergas.andrea.tcgcollection.dtos.PokemonTypeStats;
import it.sergas.andrea.tcgcollection.dtos.TypeCount;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.Collections.emptyList;

/**
 * Repository for performing aggregation operations across card collections.
 */
@Repository
@RequiredArgsConstructor
public class AggregationRepository {

    private final MongoTemplate mongoTemplate;

    /**
     * Counts Yu-Gi-Oh! cards grouped by card type (Monster, Spell, Trap).
     *
     * @return list of card type counts
     */
    public List<TypeCount> countYugiohCardsByType() {
        // TODO: implement me
        return emptyList();
    }

    /**
     * Calculates statistics for Pokémon cards grouped by type.
     * This aggregation performs the following steps:
     * <ol>
     *     <li>Filters cards that have a valid HP value</li>
     *     <li>Converts HP from string to integer</li>
     *     <li>Groups by pokemonType and calculates count, average HP, and max attack count</li>
     *     <li>Sorts results by card count in descending order</li>
     * </ol>
     *
     * @return list of Pokémon statistics per type
     */
    public List<PokemonTypeStats> getPokemonStatsByType() {
        // TODO: implement me
        return emptyList();
    }
}
