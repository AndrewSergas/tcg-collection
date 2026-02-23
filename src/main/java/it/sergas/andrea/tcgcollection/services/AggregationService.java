package it.sergas.andrea.tcgcollection.services;

import it.sergas.andrea.tcgcollection.dtos.PokemonTypeStats;
import it.sergas.andrea.tcgcollection.dtos.TypeCount;
import it.sergas.andrea.tcgcollection.repositories.AggregationRepository;
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
     * Counts Yu-Gi-Oh! cards grouped by card type.
     *
     * @return list of card type counts
     */
    public List<TypeCount> countYugiohCardsByType() {
        return repository.countYugiohCardsByType();
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
