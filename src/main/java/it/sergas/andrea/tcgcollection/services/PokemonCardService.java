package it.sergas.andrea.tcgcollection.services;

import it.sergas.andrea.tcgcollection.dtos.PokemonCardDTO;
import it.sergas.andrea.tcgcollection.mappers.PokemonCardMapper;
import it.sergas.andrea.tcgcollection.repositories.PokemonCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for managing Pokémon cards.
 */
@Service
@RequiredArgsConstructor
public class PokemonCardService {

    private final PokemonCardMapper mapper;
    private final PokemonCardRepository repository;

    /**
     * Finds Pokémon cards by rarity.
     *
     * @param rarity the rarity to search for
     * @return list of Pokémon card DTOs with the specified rarity
     */
    public List<PokemonCardDTO> findByRarity(final String rarity) {
        return repository.findByRarity(rarity).stream().map(mapper::toDTO).toList();
    }

    /**
     * Finds Pokémon cards by type.
     *
     * @param type the type to search for
     * @return list of Pokémon card DTOs with the specified type
     */
    public List<PokemonCardDTO> findByType(final String type) {
        return repository.findByType(type).stream().map(mapper::toDTO).toList();
    }

    /**
     * Finds Pokémon cards that have attacks.
     *
     * @return list of Pokémon card DTOs with attacks
     */
    public List<PokemonCardDTO> findCardsWithAttacks() {
        return repository.findCardsWithAttacks().stream().map(mapper::toDTO).toList();
    }

    /**
     * Finds all Pokémon cards.
     *
     * @return list of all Pokémon card DTOs
     */
    public List<PokemonCardDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }
}
