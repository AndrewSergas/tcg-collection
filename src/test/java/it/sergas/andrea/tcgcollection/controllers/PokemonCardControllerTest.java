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
    @MockitoBean private PokemonCardService systemUnderTest;

    @Test
    @DisplayName("getAllCards should return the Pikachu card")
    void getAllCards_shouldReturnThePikachuCard() throws Exception {
        val dto = PokemonCardDTOFixtures.pikachu();
        when(systemUnderTest.findAll()).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/pokemon"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Pikachu"))
                .andExpect(jsonPath("$[0].rarity").value("Common"));
    }

    @Test
    @DisplayName("getAllCards should return an empty list when no cards are found")
    void getAllCards_shouldReturnEmptyList_whenNoCardsAreFound() throws Exception {
        when(systemUnderTest.findAll()).thenReturn(List.of());

        mockMvc.perform(get("/api/pokemon"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    @DisplayName("findByRarity should find the common Pikachu card")
    void findByRarity_shouldFindTheCommonPikachu() throws Exception {
        val dto = PokemonCardDTOFixtures.pikachu();
        when(systemUnderTest.findByRarity("Common")).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/pokemon/rarity/Common"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Pikachu"))
                .andExpect(jsonPath("$[0].rarity").value("Common"));
    }

    @Test
    @DisplayName("findByRarity should return an empty list when no cards are found by rarity")
    void findByRarity_shouldReturnEmptyList_whenNoCardsAreFoundByRarity() throws Exception {
        when(systemUnderTest.findByRarity("Ultra Rare")).thenReturn(List.of());

        mockMvc.perform(get("/api/pokemon/rarity/Ultra Rare"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    @DisplayName("findByType should find the Lightning type Pikachu card")
    void findByType_shouldFindTheLightningTypePikachu() throws Exception {
        val dto = PokemonCardDTOFixtures.pikachu();
        when(systemUnderTest.findByType("Lightning")).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/pokemon/type/Lightning"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Pikachu"))
                .andExpect(jsonPath("$[0].types[0]").value("Lightning"));
    }

    @Test
    @DisplayName("findByType should return an empty list when no cards are found by type")
    void findByType_shouldReturnEmptyList_whenNoCardsAreFoundByType() throws Exception {
        when(systemUnderTest.findByType("Dragon")).thenReturn(List.of());

        mockMvc.perform(get("/api/pokemon/type/Dragon"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    @DisplayName("findCardsWithAttacks should find the Pikachu card with attacks")
    void findCardsWithAttacks_shouldFindThePikachuCardWithAttacks() throws Exception {
        val dto = PokemonCardDTOFixtures.pikachu();
        when(systemUnderTest.findCardsWithAttacks()).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/pokemon/with-attacks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Pikachu"))
                .andExpect(jsonPath("$[0].attacks").isNotEmpty());
    }

    @Test
    @DisplayName("findCardsWithAttacks should return an empty list when no cards have attacks")
    void findCardsWithAttacks_shouldReturnEmptyList_whenNoCardsHaveAttacks() throws Exception {
        when(systemUnderTest.findCardsWithAttacks()).thenReturn(List.of());

        mockMvc.perform(get("/api/pokemon/with-attacks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }
}
