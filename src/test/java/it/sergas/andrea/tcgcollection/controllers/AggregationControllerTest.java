package it.sergas.andrea.tcgcollection.controllers;

import it.sergas.andrea.tcgcollection.dtos.PokemonTypeStats;
import it.sergas.andrea.tcgcollection.dtos.TypeCount;
import it.sergas.andrea.tcgcollection.services.AggregationService;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DisplayName("AggregationController Tests")
class AggregationControllerTest {

    @Autowired private MockMvc mockMvc;
    @MockitoBean private AggregationService service;

    @Test
    @DisplayName("Should count yugioh cards by type")
    void shouldCountYugiohCardsByType() throws Exception {
        val typeCount = TypeCount.builder().type("Monster").count(5L).build();
        when(service.countYugiohCardsByType()).thenReturn(List.of(typeCount));

        mockMvc.perform(get("/api/aggregations/yugioh-cards-by-type"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].type").value("Monster"))
                .andExpect(jsonPath("$[0].count").value(5));
    }

    @Test
    @DisplayName("Should return empty list when no yugioh cards by type")
    void shouldReturnEmptyListWhenNoYugiohCardsByType() throws Exception {
        when(service.countYugiohCardsByType()).thenReturn(List.of());

        mockMvc.perform(get("/api/aggregations/yugioh-cards-by-type"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    @DisplayName("Should get pokemon stats by type")
    void shouldGetPokemonStatsByType() throws Exception {
        val stats = PokemonTypeStats.builder()
                .pokemonType("Basic")
                .cardCount(3L)
                .averageHp(53.33)
                .maxAttacks(2)
                .build();

        when(service.getPokemonStatsByType()).thenReturn(List.of(stats));

        mockMvc.perform(get("/api/aggregations/pokemon-stats-by-type"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].pokemonType").value("Basic"))
                .andExpect(jsonPath("$[0].cardCount").value(3))
                .andExpect(jsonPath("$[0].averageHp").value(53.33))
                .andExpect(jsonPath("$[0].maxAttacks").value(2));
    }

    @Test
    @DisplayName("Should return empty list when no pokemon stats")
    void shouldReturnEmptyListWhenNoPokemonStats() throws Exception {
        when(service.getPokemonStatsByType()).thenReturn(List.of());

        mockMvc.perform(get("/api/aggregations/pokemon-stats-by-type"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }
}
