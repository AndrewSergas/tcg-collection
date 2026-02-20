package it.finconsgroup.tcgcollection.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO representing Pokémon card statistics grouped by type.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PokemonTypeStats {
    private String pokemonType;
    private Long cardCount;
    private Double averageHp;
    private Integer maxAttacks;
}
