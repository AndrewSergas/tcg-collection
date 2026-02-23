package it.sergas.andrea.tcgcollection.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static it.sergas.andrea.tcgcollection.fixtures.OnePieceCardFixtures.luffy;
import static it.sergas.andrea.tcgcollection.fixtures.OnePieceCardFixtures.nami;
import static it.sergas.andrea.tcgcollection.fixtures.OnePieceCardFixtures.robin;
import static it.sergas.andrea.tcgcollection.fixtures.OnePieceCardFixtures.sanji;
import static it.sergas.andrea.tcgcollection.fixtures.OnePieceCardFixtures.zoro;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("OnePieceCardRepository Tests")
class OnePieceCardRepositoryTest
        extends BaseRepositoryTest {

    @Autowired private OnePieceCardRepository repository;

    @BeforeEach
    void setUp() {
        repository.saveAll(List.of(luffy(), zoro(), nami(), sanji(), robin()));
    }

    @ParameterizedTest
    @CsvSource({"Red, 2", "Green, 1", "Blue, 1", "Purple, 1"})
    @DisplayName("Should find cards by color")
    void shouldFindCardsByColor(final String color, final int expectedCount) {
        assertThat(repository.findByColor(color))
                .hasSize(expectedCount)
                .allMatch(card -> card.getColors().contains(color));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Yellow", "Black", "Orange"})
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
    @CsvSource({"3000, 4", "4000, 2", "0, 5", "5000, 0"})
    @DisplayName("Should find cards by power greater than")
    void shouldFindCardsByPowerGreaterThan(final int power, final int expectedCount) {
        assertThat(repository.findByPowerGreaterThan(power))
                .hasSize(expectedCount)
                .allMatch(card -> card.getPower() > power);
    }

    @ParameterizedTest
    @ValueSource(ints = {10000, 20000, 100000})
    @DisplayName("Should return empty list for very high power values")
    void shouldReturnEmptyListForVeryHighPowerValues(final int power) {
        assertThat(repository.findByPowerGreaterThan(power)).isEmpty();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -100, -1000})
    @DisplayName("Should find all cards for negative power values")
    void shouldFindAllCardsForNegativePowerValues(final int power) {
        assertThat(repository.findByPowerGreaterThan(power)).hasSize(5);
    }
}
