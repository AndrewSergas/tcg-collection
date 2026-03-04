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
    @InjectMocks private AggregationService service;

    @Test
    @DisplayName("Should count yugioh cards by type")
    void shouldCountYugiohCardsByType() {
        val typeCount = TypeCount.builder().type("Monster").count(5L).build();
        when(repository.countYugiohCardsByType()).thenReturn(List.of(typeCount));
        assertThat(service.countYugiohCardsByType()).containsExactly(typeCount);
    }

    @Test
    @DisplayName("Should return empty list when no yugioh cards")
    void shouldReturnEmptyListWhenNoYugiohCards() {
        when(repository.countYugiohCardsByType()).thenReturn(List.of());
        assertThat(service.countYugiohCardsByType()).isEmpty();
    }

    @Test
    @DisplayName("Should get pokemon stats by type")
    void shouldGetPokemonStatsByType() {
        val stats = PokemonTypeStats.builder()
                .pokemonType("Basic")
                .cardCount(3L)
                .averageHp(53.33)
                .maxAttacks(2)
                .build();

        when(repository.getPokemonStatsByType()).thenReturn(List.of(stats));
        assertThat(service.getPokemonStatsByType()).containsExactly(stats);
    }

    @Test
    @DisplayName("Should return empty list when no pokemon stats")
    void shouldReturnEmptyListWhenNoPokemonStats() {
        when(repository.getPokemonStatsByType()).thenReturn(List.of());
        assertThat(service.getPokemonStatsByType()).isEmpty();
    }
}
