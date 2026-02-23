package it.sergas.andrea.tcgcollection.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static it.sergas.andrea.tcgcollection.fixtures.YugiohCardFixtures.blueEyesWhiteDragon;
import static it.sergas.andrea.tcgcollection.fixtures.YugiohCardFixtures.darkMagician;
import static it.sergas.andrea.tcgcollection.fixtures.YugiohCardFixtures.kuriboh;
import static it.sergas.andrea.tcgcollection.fixtures.YugiohCardFixtures.mirrorForce;
import static it.sergas.andrea.tcgcollection.fixtures.YugiohCardFixtures.potOfGreed;
import static it.sergas.andrea.tcgcollection.fixtures.YugiohCardFixtures.shieldWall;
import static it.sergas.andrea.tcgcollection.fixtures.YugiohCardFixtures.wallOfIllusion;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("YugiohCardRepository Tests")
class YugiohCardRepositoryTest
        extends BaseRepositoryTest {

    @Autowired private YugiohCardRepository repository;

    @BeforeEach
    void setUp() {
        repository.saveAll(List.of(
                darkMagician(),
                blueEyesWhiteDragon(),
                kuriboh(),
                wallOfIllusion(),
                shieldWall(),
                mirrorForce(),
                potOfGreed()
        ));
    }

    @ParameterizedTest
    @CsvSource({"Monster, 5", "Spell, 1", "Trap, 1"})
    @DisplayName("Should find cards by card type")
    void shouldFindCardsByCardType(final String cardType, final int expectedCount) {
        assertThat(repository.findByCardType(cardType))
                .hasSize(expectedCount)
                .allMatch(card -> card.getCardType().equals(cardType));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Fusion", "Xyz", "Synchro"})
    @DisplayName("Should return empty list for non-existent card types")
    void shouldReturnEmptyListForNonExistentCardTypes(final String cardType) {
        assertThat(repository.findByCardType(cardType)).isEmpty();
    }

    @ParameterizedTest
    @ValueSource(strings = {"monster", "MONSTER", "MoNsTeR"})
    @DisplayName("Should handle case-sensitive card type search")
    void shouldHandleCaseSensitiveCardTypeSearch(final String cardType) {
        assertThat(repository.findByCardType(cardType)).isEmpty();
    }

    @ParameterizedTest
    @CsvSource({"1000, 2", "500, 3", "2500, 1", "0, 5", "3000, 0"})
    @DisplayName("Should find cards by attack greater than")
    void shouldFindCardsByAttackGreaterThan(final int attack, final int expectedCount) {
        assertThat(repository.findByAttackGreaterThan(attack))
                .hasSize(expectedCount)
                .allMatch(card -> card.getAttack() != null && card.getAttack() > attack);
    }

    @ParameterizedTest
    @ValueSource(ints = {10000, 20000, 100000})
    @DisplayName("Should return empty list for very high attack values")
    void shouldReturnEmptyListForVeryHighAttackValues(final int attack) {
        assertThat(repository.findByAttackGreaterThan(attack)).isEmpty();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -100, -1000})
    @DisplayName("Should find all monster cards for negative attack values")
    void shouldFindAllMonsterCardsForNegativeAttackValues(final int attack) {
        assertThat(repository.findByAttackGreaterThan(attack)).hasSize(5);
    }

    @ParameterizedTest
    @CsvSource({"2"})
    @DisplayName("Should find cards with defense greater than attack")
    void shouldFindCardsWithDefenseGreaterThanAttack(final int expectedCount) {
        assertThat(repository.findCardsWithDefenseGreaterThanAttack())
                .hasSize(expectedCount)
                .allMatch(card -> card.getDefense() != null && card.getAttack() != null)
                .allMatch(card -> card.getDefense() > card.getAttack());
    }
}
