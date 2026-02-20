package it.finconsgroup.tcgcollection.controllers;

import it.finconsgroup.tcgcollection.dtos.PokemonTypeStats;
import it.finconsgroup.tcgcollection.dtos.RarityCount;
import it.finconsgroup.tcgcollection.services.AggregationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for aggregation operations across card collections.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/aggregations")
public class AggregationController {

    private final AggregationService service;

    /**
     * Counts cards grouped by rarity across all collections.
     *
     * @return list of rarity counts
     */
    @GetMapping("/cards-by-rarity")
    public List<RarityCount> countCardsByRarity() {
        return service.countCardsByRarity();
    }

    /**
     * Calculates statistics for Pokémon cards grouped by type.
     *
     * @return list of Pokémon statistics per type
     */
    @GetMapping("/pokemon-stats-by-type")
    public List<PokemonTypeStats> getPokemonStatsByType() {
        return service.getPokemonStatsByType();
    }
}
