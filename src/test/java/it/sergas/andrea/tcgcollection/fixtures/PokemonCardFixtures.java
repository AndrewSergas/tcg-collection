package it.sergas.andrea.tcgcollection.fixtures;

import it.sergas.andrea.tcgcollection.entities.PokemonCard;
import lombok.NoArgsConstructor;
import lombok.val;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class PokemonCardFixtures {

    public static PokemonCard pikachu() {
        val thunderShock = PokemonCard.Attack.builder().name("Thunder Shock").damage("10").build();
        val agility = PokemonCard.Attack.builder().name("Agility").damage("20").build();
        val weakness = PokemonCard.Weakness.builder().type("Fighting").value("×2").build();
        val resistance = PokemonCard.Resistance.builder().type("Metal").value("-20").build();

        return PokemonCard.builder()
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

    public static PokemonCard charizard() {
        val fireSpin = PokemonCard.Attack.builder().name("Fire Spin").damage("100").build();
        val flamethrower = PokemonCard.Attack.builder().name("Flamethrower").damage("60").build();
        val weakness = PokemonCard.Weakness.builder().type("Water").value("×2").build();
        val resistance = PokemonCard.Resistance.builder().type("Fighting").value("-30").build();

        return PokemonCard.builder()
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

    public static PokemonCard mewtwo() {
        val psychic = PokemonCard.Attack.builder().name("Psychic").damage("10+").build();
        val barrier = PokemonCard.Attack.builder().name("Barrier").damage("30").build();
        val weakness = PokemonCard.Weakness.builder().type("Psychic").value("×2").build();

        return PokemonCard.builder()
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

    public static PokemonCard bulbasaur() {
        val leechSeed = PokemonCard.Attack.builder().name("Leech Seed").damage("20").build();
        val weakness = PokemonCard.Weakness.builder().type("Fire").value("×2").build();

        return PokemonCard.builder()
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

    public static PokemonCard squirtle() {
        val bubble = PokemonCard.Attack.builder().name("Bubble").damage("10").build();
        val withdraw = PokemonCard.Attack.builder().name("Withdraw").damage("").build();
        val weakness = PokemonCard.Weakness.builder().type("Lightning").value("×2").build();

        return PokemonCard.builder()
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

    public static PokemonCard energyCard() {
        return PokemonCard.builder()
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
