package it.finconsgroup.tcgcollection.services;

import it.finconsgroup.tcgcollection.dtos.PokemonTypeStats;
import it.finconsgroup.tcgcollection.dtos.RarityCount;
import it.finconsgroup.tcgcollection.repositories.AggregationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for performing aggregation operations across card collections.
 */
@Service
@RequiredArgsConstructor
public class AggregationService {

    private final AggregationRepository repository;

    /**
     * Counts cards grouped by rarity across all collections.
     *
     * @return list of rarity counts
     */
    public List<RarityCount> countCardsByRarity() {
        return repository.countCardsByRarityAcrossAllCollections();
    }

    /**
     * Calculates statistics for Pokémon cards grouped by type.
     *
     * @return list of Pokémon statistics per type
     */
    public List<PokemonTypeStats> getPokemonStatsByType() {
        return repository.getPokemonStatsByType();
    }
}
