package it.sergas.andrea.tcgcollection.fixtures;

import it.sergas.andrea.tcgcollection.dtos.PokemonCardDTO;
import lombok.NoArgsConstructor;
import lombok.val;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class PokemonCardDTOFixtures {

    public static PokemonCardDTO pikachu() {
        val thunderShock = PokemonCardDTO.AttackDTO.builder().name("Thunder Shock").damage("10").build();
        val agility = PokemonCardDTO.AttackDTO.builder().name("Agility").damage("20").build();
        val weakness = PokemonCardDTO.WeaknessDTO.builder().type("Fighting").value("×2").build();
        val resistance = PokemonCardDTO.ResistanceDTO.builder().type("Metal").value("-20").build();

        return PokemonCardDTO.builder()
                .id("000000000000000000000001")
                .name("Pikachu")
                .rarity("Common")
                .setName("Base Set")
                .setCode("BS")
                .cardNumber("058")
                .types(List.of("Lightning"))
                .hp("60")
                .pokemonType("Basic")
                .attacks(List.of(thunderShock, agility))
                .weaknesses(List.of(weakness))
                .resistances(List.of(resistance))
                .retreatCost("1")
                .build();
    }

    public static PokemonCardDTO charizard() {
        val fireSpin = PokemonCardDTO.AttackDTO.builder().name("Fire Spin").damage("100").build();
        val flamethrower = PokemonCardDTO.AttackDTO.builder().name("Flamethrower").damage("60").build();
        val weakness = PokemonCardDTO.WeaknessDTO.builder().type("Water").value("×2").build();
        val resistance = PokemonCardDTO.ResistanceDTO.builder().type("Fighting").value("-30").build();

        return PokemonCardDTO.builder()
                .id("000000000000000000000002")
                .name("Charizard")
                .rarity("Rare Holo")
                .setName("Base Set")
                .setCode("BS")
                .cardNumber("004")
                .types(List.of("Fire"))
                .hp("120")
                .pokemonType("Stage 2")
                .attacks(List.of(fireSpin, flamethrower))
                .weaknesses(List.of(weakness))
                .resistances(List.of(resistance))
                .retreatCost("3")
                .build();
    }
}
