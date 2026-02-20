package it.finconsgroup.tcgcollection.repositories;

import it.finconsgroup.tcgcollection.dtos.PokemonTypeStats;
import it.finconsgroup.tcgcollection.dtos.RarityCount;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for performing aggregation operations across card collections.
 */
@Repository
@RequiredArgsConstructor
public class AggregationRepository {

    private final MongoTemplate mongoTemplate;

    /**
     * Counts cards grouped by rarity across all collections.
     *
     * @return list of rarity counts
     */
    public List<RarityCount> countCardsByRarityAcrossAllCollections() {
        // TODO: Implement aggregation pipeline
        return List.of();
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
        // TODO: Implement aggregation pipeline
        return List.of();
    }
}
