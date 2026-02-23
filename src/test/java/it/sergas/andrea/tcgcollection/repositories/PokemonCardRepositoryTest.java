package it.sergas.andrea.tcgcollection.repositories;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static it.sergas.andrea.tcgcollection.fixtures.PokemonCardFixtures.bulbasaur;
import static it.sergas.andrea.tcgcollection.fixtures.PokemonCardFixtures.charizard;
import static it.sergas.andrea.tcgcollection.fixtures.PokemonCardFixtures.energyCard;
import static it.sergas.andrea.tcgcollection.fixtures.PokemonCardFixtures.mewtwo;
import static it.sergas.andrea.tcgcollection.fixtures.PokemonCardFixtures.pikachu;
import static it.sergas.andrea.tcgcollection.fixtures.PokemonCardFixtures.squirtle;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("PokemonCardRepository Tests")
class PokemonCardRepositoryTest
        extends BaseRepositoryTest {

    @Autowired private PokemonCardRepository repository;

    @BeforeEach
    void setUp() {
        repository.saveAll(List.of(pikachu(), charizard(), mewtwo(), bulbasaur(), squirtle(), energyCard()));
    }

    @ParameterizedTest
    @CsvSource({"Common, 3", "Rare, 1", "Rare Holo, 1", "Uncommon, 1"})
    @DisplayName("Should find cards by rarity")
    void shouldFindCardsByRarity(final String rarity, final int expectedCount) {
        assertThat(repository.findByRarity(rarity))
                .hasSize(expectedCount)
                .allMatch(card -> card.getRarity().equals(rarity));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Ultra Rare", "Secret Rare", "Promo"})
    @DisplayName("Should return empty list for non-existent rarities")
    void shouldReturnEmptyListForNonExistentRarities(final String rarity) {
        assertThat(repository.findByRarity(rarity)).isEmpty();
    }

    @ParameterizedTest
    @ValueSource(strings = {"common", "COMMON", "CoMmOn"})
    @DisplayName("Should handle case-sensitive rarity search")
    void shouldHandleCaseSensitiveRaritySearch(final String rarity) {
        assertThat(repository.findByRarity(rarity)).isEmpty();
    }

    @ParameterizedTest
    @CsvSource({"Lightning, 1", "Fire, 1", "Psychic, 1", "Grass, 1", "Water, 1"})
    @DisplayName("Should find cards by type")
    void shouldFindCardsByType(final String type, final int expectedCount) {
        assertThat(repository.findByType(type))
                .hasSize(expectedCount)
                .allMatch(card -> card.getTypes().contains(type));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Fighting", "Dragon", "Fairy"})
    @DisplayName("Should return empty list for non-existent types")
    void shouldReturnEmptyListForNonExistentTypes(final String type) {
        assertThat(repository.findByType(type)).isEmpty();
    }

    @ParameterizedTest
    @ValueSource(strings = {"fire", "FIRE", "FiRe"})
    @DisplayName("Should handle case-sensitive type search")
    void shouldHandleCaseSensitiveTypeSearch(final String type) {
        assertThat(repository.findByType(type)).isEmpty();
    }

    @ParameterizedTest
    @CsvSource({"5"})
    @DisplayName("Should find cards with attacks")
    void shouldFindCardsWithAttacks(final int expectedCount) {
        assertThat(repository.findCardsWithAttacks())
                .hasSize(expectedCount)
                .allMatch(card -> card.getAttacks() != null && !card.getAttacks().isEmpty());
    }

    @ParameterizedTest
    @CsvSource({"1"})
    @DisplayName("Should not find cards without attacks")
    void shouldNotFindCardsWithoutAttacks(final int expectedCardsWithoutAttacks) {
        val totalCards = 6;
        val cardsWithAttacks = repository.findCardsWithAttacks().size();
        assertThat(totalCards - cardsWithAttacks).isEqualTo(expectedCardsWithoutAttacks);
    }
}
