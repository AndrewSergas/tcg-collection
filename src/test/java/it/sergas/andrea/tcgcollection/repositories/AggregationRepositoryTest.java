package it.sergas.andrea.tcgcollection.repositories;

import it.sergas.andrea.tcgcollection.dtos.PokemonTypeStats;
import it.sergas.andrea.tcgcollection.dtos.TypeCount;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

import java.util.List;

import static it.sergas.andrea.tcgcollection.fixtures.PokemonCardFixtures.bulbasaur;
import static it.sergas.andrea.tcgcollection.fixtures.PokemonCardFixtures.charizard;
import static it.sergas.andrea.tcgcollection.fixtures.PokemonCardFixtures.energyCard;
import static it.sergas.andrea.tcgcollection.fixtures.PokemonCardFixtures.mewtwo;
import static it.sergas.andrea.tcgcollection.fixtures.PokemonCardFixtures.pikachu;
import static it.sergas.andrea.tcgcollection.fixtures.PokemonCardFixtures.squirtle;
import static it.sergas.andrea.tcgcollection.fixtures.YugiohCardFixtures.blueEyesWhiteDragon;
import static it.sergas.andrea.tcgcollection.fixtures.YugiohCardFixtures.darkMagician;
import static it.sergas.andrea.tcgcollection.fixtures.YugiohCardFixtures.kuriboh;
import static it.sergas.andrea.tcgcollection.fixtures.YugiohCardFixtures.mirrorForce;
import static it.sergas.andrea.tcgcollection.fixtures.YugiohCardFixtures.potOfGreed;
import static it.sergas.andrea.tcgcollection.fixtures.YugiohCardFixtures.shieldWall;
import static it.sergas.andrea.tcgcollection.fixtures.YugiohCardFixtures.wallOfIllusion;
import static java.util.Comparator.comparingLong;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
import static org.assertj.core.api.InstanceOfAssertFactories.DOUBLE;

@Import(AggregationRepository.class)
@DisplayName("AggregationRepository Tests")
class AggregationRepositoryTest
        extends BaseRepositoryTest {

    @Autowired private YugiohCardRepository yugiohRepository;
    @Autowired private PokemonCardRepository pokemonRepository;
    @Autowired private AggregationRepository aggregationRepository;

    @BeforeEach
    void setUp() {
        yugiohRepository.saveAll(List.of(
                darkMagician(),
                blueEyesWhiteDragon(),
                kuriboh(),
                wallOfIllusion(),
                shieldWall(),
                mirrorForce(),
                potOfGreed()
        ));
    }

    @Test
    @DisplayName("Should count Yu-Gi-Oh! cards by type")
    void shouldCountYugiohCardsByType() {
        assertThat(aggregationRepository.countYugiohCardsByType())
                .isNotEmpty()
                .hasSize(3)
                .anyMatch(count -> count.getType().equals("Monster") && count.getCount() == 5)
                .anyMatch(count -> count.getType().equals("Spell") && count.getCount() == 1)
                .anyMatch(count -> count.getType().equals("Trap") && count.getCount() == 1);
    }

    @Test
    @DisplayName("Should sort results by count descending")
    void shouldSortResultsByCountDescending() {
        assertThat(aggregationRepository.countYugiohCardsByType())
                .isNotEmpty()
                .isSortedAccordingTo(comparingLong(TypeCount::getCount).reversed())
                .first()
                .matches(typeCount -> typeCount.getType().equals("Monster"))
                .matches(typeCount -> typeCount.getCount() == 5);
    }

    @Test
    @DisplayName("Should return empty list when no cards exist")
    void shouldReturnEmptyListWhenNoCardsExist() {
        yugiohRepository.deleteAll();
        assertThat(aggregationRepository.countYugiohCardsByType()).isEmpty();
    }

    @Test
    @DisplayName("Should calculate Pokémon statistics by type")
    void shouldCalculatePokemonStatsByType() {
        pokemonRepository.saveAll(List.of(
                pikachu(),
                charizard(),
                mewtwo(),
                bulbasaur(),
                squirtle(),
                energyCard()
        ));

        val result = aggregationRepository.getPokemonStatsByType();
        assertThat(result).isNotEmpty().hasSize(2);

        val basicStats = result.stream()
                .filter(stats -> stats.getPokemonType().equals("Basic"))
                .findFirst()
                .orElseThrow();

        assertThat(basicStats)
                .returns(4L, PokemonTypeStats::getCardCount)
                .returns(2, PokemonTypeStats::getMaxAttacks)
                .extracting(PokemonTypeStats::getAverageHp).asInstanceOf(DOUBLE).isCloseTo(50.0, within(0.1));

        val stage2Stats = result.stream()
                .filter(stats -> stats.getPokemonType().equals("Stage 2"))
                .findFirst()
                .orElseThrow();

        assertThat(stage2Stats)
                .returns(1L, PokemonTypeStats::getCardCount)
                .returns(2, PokemonTypeStats::getMaxAttacks)
                .extracting(PokemonTypeStats::getAverageHp).asInstanceOf(DOUBLE).isCloseTo(120.0, within(0.1));
    }

    @Test
    @DisplayName("Should filter out cards without HP")
    void shouldFilterOutCardsWithoutHp() {
        pokemonRepository.saveAll(List.of(pikachu(), energyCard()));

        assertThat(aggregationRepository.getPokemonStatsByType())
                .hasSize(1)
                .allMatch(stats -> stats.getPokemonType().equals("Basic"));
    }

    @Test
    @DisplayName("Should sort Pokémon stats by card count descending")
    void shouldSortPokemonStatsByCardCountDescending() {
        pokemonRepository.saveAll(List.of(
                pikachu(),
                mewtwo(),
                bulbasaur(),
                squirtle(),
                charizard()
        ));

        assertThat(aggregationRepository.getPokemonStatsByType())
                .isNotEmpty()
                .isSortedAccordingTo(comparingLong(PokemonTypeStats::getCardCount).reversed())
                .first()
                .matches(typeStats -> typeStats.getPokemonType().equals("Basic"))
                .matches(typeStats -> typeStats.getCardCount() == 4);
    }

    @Test
    @DisplayName("Should calculate correct average HP")
    void shouldCalculateCorrectAverageHp() {
        pokemonRepository.saveAll(List.of(bulbasaur(), squirtle()));

        assertThat(aggregationRepository.getPokemonStatsByType())
                .hasSize(1)
                .first()
                .returns(2, PokemonTypeStats::getMaxAttacks)
                .extracting(PokemonTypeStats::getAverageHp).asInstanceOf(DOUBLE).isCloseTo(40.0, within(0.1));
    }

    @Test
    @DisplayName("Should return empty list when no Pokémon cards exist")
    void shouldReturnEmptyListWhenNoPokemonCardsExist() {
        assertThat(aggregationRepository.getPokemonStatsByType()).isEmpty();
    }
}
