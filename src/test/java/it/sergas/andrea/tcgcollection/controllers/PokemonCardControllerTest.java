package it.sergas.andrea.tcgcollection.controllers;

import it.sergas.andrea.tcgcollection.fixtures.PokemonCardDTOFixtures;
import it.sergas.andrea.tcgcollection.services.PokemonCardService;
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
@DisplayName("PokemonCardController Tests")
class PokemonCardControllerTest {

    @Autowired private MockMvc mockMvc;
    @MockitoBean private PokemonCardService service;

    @Test
    @DisplayName("Should get all cards")
    void shouldGetAllCards() throws Exception {
        val dto = PokemonCardDTOFixtures.pikachu();
        when(service.findAll()).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/pokemon"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Pikachu"))
                .andExpect(jsonPath("$[0].rarity").value("Common"));
    }

    @Test
    @DisplayName("Should return empty list when no cards")
    void shouldReturnEmptyListWhenNoCards() throws Exception {
        when(service.findAll()).thenReturn(List.of());

        mockMvc.perform(get("/api/pokemon"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    @DisplayName("Should find cards by rarity")
    void shouldFindCardsByRarity() throws Exception {
        val dto = PokemonCardDTOFixtures.pikachu();
        when(service.findByRarity("Common")).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/pokemon/rarity/Common"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Pikachu"))
                .andExpect(jsonPath("$[0].rarity").value("Common"));
    }

    @Test
    @DisplayName("Should return empty list for non-existent rarity")
    void shouldReturnEmptyListForNonExistentRarity() throws Exception {
        when(service.findByRarity("Ultra Rare")).thenReturn(List.of());

        mockMvc.perform(get("/api/pokemon/rarity/Ultra Rare"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    @DisplayName("Should find cards by type")
    void shouldFindCardsByType() throws Exception {
        val dto = PokemonCardDTOFixtures.pikachu();
        when(service.findByType("Lightning")).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/pokemon/type/Lightning"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Pikachu"))
                .andExpect(jsonPath("$[0].types[0]").value("Lightning"));
    }

    @Test
    @DisplayName("Should return empty list for non-existent type")
    void shouldReturnEmptyListForNonExistentType() throws Exception {
        when(service.findByType("Dragon")).thenReturn(List.of());

        mockMvc.perform(get("/api/pokemon/type/Dragon"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    @DisplayName("Should find cards with attacks")
    void shouldFindCardsWithAttacks() throws Exception {
        val dto = PokemonCardDTOFixtures.pikachu();
        when(service.findCardsWithAttacks()).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/pokemon/with-attacks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Pikachu"))
                .andExpect(jsonPath("$[0].attacks").isNotEmpty());
    }

    @Test
    @DisplayName("Should return empty list when no cards with attacks")
    void shouldReturnEmptyListWhenNoCardsWithAttacks() throws Exception {
        when(service.findCardsWithAttacks()).thenReturn(List.of());

        mockMvc.perform(get("/api/pokemon/with-attacks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }
}
