package it.sergas.andrea.tcgcollection.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static it.sergas.andrea.tcgcollection.fixtures.MagicCardFixtures.blackLotus;
import static it.sergas.andrea.tcgcollection.fixtures.MagicCardFixtures.counterspell;
import static it.sergas.andrea.tcgcollection.fixtures.MagicCardFixtures.giantGrowth;
import static it.sergas.andrea.tcgcollection.fixtures.MagicCardFixtures.lightningBolt;
import static it.sergas.andrea.tcgcollection.fixtures.MagicCardFixtures.serraAngel;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("MagicCardRepository Tests")
class MagicCardRepositoryTest extends BaseRepositoryTest {

    @Autowired private MagicCardRepository repository;

    @BeforeEach
    void setUp() {
        repository.saveAll(List.of(lightningBolt(), blackLotus(), counterspell(), serraAngel(), giantGrowth()));
    }

    @ParameterizedTest
    @CsvSource({"Instant, 3", "Artifact, 1", "Creature - Angel, 1"})
    @DisplayName("Should find cards by type")
    void shouldFindCardsByType(final String type, final int expectedCount) {
        assertThat(repository.findByType(type))
                .hasSize(expectedCount)
                .allMatch(card -> card.getType().equals(type));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Sorcery", "Enchantment", "Planeswalker"})
    @DisplayName("Should return empty list for non-existent types")
    void shouldReturnEmptyListForNonExistentTypes(final String type) {
        assertThat(repository.findByType(type)).isEmpty();
    }

    @ParameterizedTest
    @ValueSource(strings = {"instant", "INSTANT", "InStAnT"})
    @DisplayName("Should handle case-sensitive type search")
    void shouldHandleCaseSensitiveTypeSearch(final String type) {
        assertThat(repository.findByType(type)).isEmpty();
    }

    @ParameterizedTest
    @CsvSource({"Red, 1", "Blue, 1", "White, 1", "Green, 1"})
    @DisplayName("Should find cards by color")
    void shouldFindCardsByColor(final String color, final int expectedCount) {
        assertThat(repository.findByColor(color))
                .hasSize(expectedCount)
                .allMatch(card -> card.getColors().contains(color));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Black", "Purple", "Orange"})
    @DisplayName("Should return empty list for non-existent colors")
    void shouldReturnEmptyListForNonExistentColors(final String color) {
        assertThat(repository.findByColor(color)).isEmpty();
    }

    @ParameterizedTest
    @ValueSource(strings = {"red", "RED", "rEd"})
    @DisplayName("Should handle case-sensitive color search")
    void shouldHandleCaseSensitiveColorSearch(final String color) {
        assertThat(repository.findByColor(color)).isEmpty();
    }

    @ParameterizedTest
    @CsvSource({"damage, 1", "Counter, 1", "Flying, 1", "gets, 1"})
    @DisplayName("Should find cards by text containing keyword")
    void shouldFindCardsByTextContaining(final String keyword, final int expectedCount) {
        assertThat(repository.findByTextContaining(keyword))
                .hasSize(expectedCount)
                .allMatch(card -> card.getText().contains(keyword));
    }

    @ParameterizedTest
    @ValueSource(strings = {"trample", "haste", "deathtouch"})
    @DisplayName("Should return empty list for non-existent keywords")
    void shouldReturnEmptyListForNonExistentKeywords(final String keyword) {
        assertThat(repository.findByTextContaining(keyword)).isEmpty();
    }

    @ParameterizedTest
    @ValueSource(strings = {"damage", "DAMAGE", "DaMaGe", "Damage"})
    @DisplayName("Should find cards with case-insensitive text search")
    void shouldFindCardsWithCaseInsensitiveTextSearch(final String keyword) {
        assertThat(repository.findByTextContaining(keyword))
                .hasSize(1)
                .allMatch(card -> card.getText().toLowerCase().contains(keyword.toLowerCase()));
    }
}
