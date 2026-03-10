package it.sergas.andrea.tcgcollection.services;

import it.sergas.andrea.tcgcollection.dtos.PokemonTypeStats;
import it.sergas.andrea.tcgcollection.dtos.TypeCount;
import it.sergas.andrea.tcgcollection.repositories.AggregationRepository;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("AggregationService Tests")
class AggregationServiceTest {

    @Mock private AggregationRepository repository;
    @InjectMocks private AggregationService systemUnderTest;

    @Test
    @DisplayName("countYugiohCardsByType should count Monster type cards")
    void countYugiohCardsByType_shouldCountMonsterTypeCards() {
        val typeCount = TypeCount.builder().type("Monster").count(5L).build();
        when(repository.countYugiohCardsByType()).thenReturn(List.of(typeCount));
        assertThat(systemUnderTest.countYugiohCardsByType()).containsExactly(typeCount);
    }

    @Test
    @DisplayName("countYugiohCardsByType should return an empty list when no yugioh cards are found")
    void countYugiohCardsByType_shouldReturnEmptyList_whenNoYugiohCardsAreFound() {
        when(repository.countYugiohCardsByType()).thenReturn(List.of());
        assertThat(systemUnderTest.countYugiohCardsByType()).isEmpty();
    }

    @Test
    @DisplayName("getPokemonStatsByType should get stats for Basic type")
    void getPokemonStatsByType_shouldGetStatsForBasicType() {
        val stats = PokemonTypeStats.builder()
                .pokemonType("Basic")
                .cardCount(3L)
                .averageHp(53.33)
                .maxAttacks(2)
                .build();

        when(repository.getPokemonStatsByType()).thenReturn(List.of(stats));
        assertThat(systemUnderTest.getPokemonStatsByType()).containsExactly(stats);
    }

    @Test
    @DisplayName("getPokemonStatsByType should return an empty list when no pokemon stats are found")
    void getPokemonStatsByType_shouldReturnEmptyList_whenNoPokemonStatsAreFound() {
        when(repository.getPokemonStatsByType()).thenReturn(List.of());
        assertThat(systemUnderTest.getPokemonStatsByType()).isEmpty();
    }
}
