package it.sergas.andrea.tcgcollection.controllers;

import it.sergas.andrea.tcgcollection.dtos.PokemonCardDTO;
import it.sergas.andrea.tcgcollection.services.PokemonCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for Pokémon card operations.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pokemon")
public class PokemonCardController {

    private final PokemonCardService service;

    /**
     * Retrieves all Pokémon cards.
     *
     * @return list of all Pokémon card DTOs
     */
    @GetMapping
    public List<PokemonCardDTO> getAllCards() {
        return service.findAll();
    }

    /**
     * Finds Pokémon cards by rarity.
     *
     * @param rarity the rarity to search for
     * @return list of Pokémon card DTOs with the specified rarity
     */
    @GetMapping("/rarity/{rarity}")
    public List<PokemonCardDTO> findByRarity(@PathVariable final String rarity) {
        return service.findByRarity(rarity);
    }

    /**
     * Finds Pokémon cards by type.
     *
     * @param type the type to search for
     * @return list of Pokémon card DTOs with the specified type
     */
    @GetMapping("/type/{type}")
    public List<PokemonCardDTO> findByType(@PathVariable final String type) {
        return service.findByType(type);
    }

    /**
     * Finds Pokémon cards that have attacks.
     *
     * @return list of Pokémon card DTOs with attacks
     */
    @GetMapping("/with-attacks")
    public List<PokemonCardDTO> findCardsWithAttacks() {
        return service.findCardsWithAttacks();
    }
}
