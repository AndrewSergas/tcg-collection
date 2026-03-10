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

    public static PokemonCardDTO mewtwo() {
        val psychic = PokemonCardDTO.AttackDTO.builder().name("Psychic").damage("10+").build();
        val barrier = PokemonCardDTO.AttackDTO.builder().name("Barrier").damage("30").build();
        val weakness = PokemonCardDTO.WeaknessDTO.builder().type("Psychic").value("×2").build();

        return PokemonCardDTO.builder()
                .id("000000000000000000000003")
                .name("Mewtwo")
                .rarity("Rare")
                .setName("Base Set")
                .setCode("BS")
                .cardNumber("010")
                .types(List.of("Psychic"))
                .hp("60")
                .pokemonType("Basic")
                .attacks(List.of(psychic, barrier))
                .weaknesses(List.of(weakness))
                .resistances(List.of())
                .retreatCost("3")
                .build();
    }

    public static PokemonCardDTO bulbasaur() {
        val leechSeed = PokemonCardDTO.AttackDTO.builder().name("Leech Seed").damage("20").build();
        val weakness = PokemonCardDTO.WeaknessDTO.builder().type("Fire").value("×2").build();

        return PokemonCardDTO.builder()
                .id("000000000000000000000004")
                .name("Bulbasaur")
                .rarity("Common")
                .setName("Base Set")
                .setCode("BS")
                .cardNumber("044")
                .types(List.of("Grass"))
                .hp("40")
                .pokemonType("Basic")
                .attacks(List.of(leechSeed))
                .weaknesses(List.of(weakness))
                .resistances(List.of())
                .retreatCost("1")
                .build();
    }

    public static PokemonCardDTO squirtle() {
        val bubble = PokemonCardDTO.AttackDTO.builder().name("Bubble").damage("10").build();
        val withdraw = PokemonCardDTO.AttackDTO.builder().name("Withdraw").damage("").build();
        val weakness = PokemonCardDTO.WeaknessDTO.builder().type("Lightning").value("×2").build();

        return PokemonCardDTO.builder()
                .id("000000000000000000000005")
                .name("Squirtle")
                .rarity("Common")
                .setName("Base Set")
                .setCode("BS")
                .cardNumber("063")
                .types(List.of("Water"))
                .hp("40")
                .pokemonType("Basic")
                .attacks(List.of(bubble, withdraw))
                .weaknesses(List.of(weakness))
                .resistances(List.of())
                .retreatCost("1")
                .build();
    }

    public static PokemonCardDTO energyCard() {
        return PokemonCardDTO.builder()
                .id("000000000000000000000006")
                .name("Double Colorless Energy")
                .rarity("Uncommon")
                .setName("Base Set")
                .setCode("BS")
                .cardNumber("096")
                .types(List.of())
                .hp(null)
                .pokemonType("Energy")
                .attacks(List.of())
                .weaknesses(List.of())
                .resistances(List.of())
                .retreatCost(null)
                .build();
    }
}
