package it.sergas.andrea.tcgcollection.controllers;

import it.sergas.andrea.tcgcollection.dtos.PokemonTypeStats;
import it.sergas.andrea.tcgcollection.dtos.TypeCount;
import it.sergas.andrea.tcgcollection.services.AggregationService;
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
     * Counts Yu-Gi-Oh! cards grouped by card type.
     *
     * @return list of card type counts
     */
    @GetMapping("/yugioh-cards-by-type")
    public List<TypeCount> countYugiohCardsByType() {
        return service.countYugiohCardsByType();
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
