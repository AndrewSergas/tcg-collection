package it.sergas.andrea.tcgcollection.repositories;

import it.sergas.andrea.tcgcollection.entities.LorcanaCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static it.sergas.andrea.tcgcollection.fixtures.LorcanaCardFixtures.elsa;
import static it.sergas.andrea.tcgcollection.fixtures.LorcanaCardFixtures.mickey;
import static it.sergas.andrea.tcgcollection.fixtures.LorcanaCardFixtures.simba;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LorcanaCardRepository Tests")
class LorcanaCardRepositoryTest extends BaseRepositoryTest {

    @Autowired private LorcanaCardRepository repository;
    private LorcanaCard elsa;

    @BeforeEach
    void setUp() {
        elsa = elsa();
        repository.saveAll(List.of(elsa, mickey(), simba()));
    }

    @ParameterizedTest
    @CsvSource({"Amber, 2", "Sapphire, 1", "Steel, 1"})
    @DisplayName("Should find cards by ink color")
    void shouldFindCardsByInkColor(final String inkColor, final int expectedCount) {
        assertThat(repository.findByInkColor(inkColor))
                .hasSize(expectedCount)
                .allMatch(card -> card.getInkColors().contains(inkColor));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Ruby", "Emerald", "Amethyst"})
    @DisplayName("Should return empty list for non-existent ink colors")
    void shouldReturnEmptyListForNonExistentInkColors(final String inkColor) {
        assertThat(repository.findByInkColor(inkColor)).isEmpty();
    }

    @ParameterizedTest
    @ValueSource(strings = {"amber", "AMBER", "aMbEr"})
    @DisplayName("Should handle case-sensitive ink color search")
    void shouldHandleCaseSensitiveInkColorSearch(final String inkColor) {
        assertThat(repository.findByInkColor(inkColor)).isEmpty();
    }

    @ParameterizedTest
    @CsvSource({"Amber, 2", "Sapphire, 1"})
    @DisplayName("Should handle cards with multiple ink colors")
    void shouldHandleCardsWithMultipleInkColors(final String inkColor, final int expectedCount) {
        assertThat(repository.findByInkColor(inkColor))
                .hasSize(expectedCount)
                .anyMatch(card -> card.getName().equals(elsa.getName()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Aladdin", "Tangled", "Mulan"})
    @DisplayName("Should return empty list for non-existent franchise titles")
    void shouldReturnEmptyListForNonExistentFranchiseTitles(final String franchiseTitle) {
        assertThat(repository.findByFranchiseTitle(franchiseTitle)).isEmpty();
    }

    @ParameterizedTest
    @ValueSource(strings = {"frozen", "FROZEN", "FrOzEn"})
    @DisplayName("Should handle case-sensitive franchise title search")
    void shouldHandleCaseSensitiveFranchiseTitleSearch(final String franchiseTitle) {
        assertThat(repository.findByFranchiseTitle(franchiseTitle)).isEmpty();
    }
}
