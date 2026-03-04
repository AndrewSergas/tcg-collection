package it.sergas.andrea.tcgcollection.controllers;

import it.sergas.andrea.tcgcollection.fixtures.MagicCardDTOFixtures;
import it.sergas.andrea.tcgcollection.services.MagicCardService;
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
@DisplayName("MagicCardController Tests")
class MagicCardControllerTest {

    @Autowired private MockMvc mockMvc;
    @MockitoBean private MagicCardService service;

    @Test
    @DisplayName("Should get all cards")
    void shouldGetAllCards() throws Exception {
        val dto = MagicCardDTOFixtures.lightningBolt();
        when(service.findAll()).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/magic"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Lightning Bolt"))
                .andExpect(jsonPath("$[0].type").value("Instant"));
    }

    @Test
    @DisplayName("Should return empty list when no cards")
    void shouldReturnEmptyListWhenNoCards() throws Exception {
        when(service.findAll()).thenReturn(List.of());

        mockMvc.perform(get("/api/magic"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    @DisplayName("Should find cards by type")
    void shouldFindCardsByType() throws Exception {
        val dto = MagicCardDTOFixtures.blackLotus();
        when(service.findByType("Artifact")).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/magic/type/Artifact"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Black Lotus"))
                .andExpect(jsonPath("$[0].type").value("Artifact"));
    }

    @Test
    @DisplayName("Should return empty list for non-existent type")
    void shouldReturnEmptyListForNonExistentType() throws Exception {
        when(service.findByType("Planeswalker")).thenReturn(List.of());

        mockMvc.perform(get("/api/magic/type/Planeswalker"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    @DisplayName("Should find cards by color")
    void shouldFindCardsByColor() throws Exception {
        val dto = MagicCardDTOFixtures.lightningBolt();
        when(service.findByColor("Red")).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/magic/color/Red"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Lightning Bolt"))
                .andExpect(jsonPath("$[0].colors[0]").value("Red"));
    }

    @Test
    @DisplayName("Should return empty list for non-existent color")
    void shouldReturnEmptyListForNonExistentColor() throws Exception {
        when(service.findByColor("Purple")).thenReturn(List.of());

        mockMvc.perform(get("/api/magic/color/Purple"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    @DisplayName("Should find cards by text containing")
    void shouldFindCardsByTextContaining() throws Exception {
        val dto = MagicCardDTOFixtures.lightningBolt();
        when(service.findByTextContaining("damage")).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/magic/text-contains/damage"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Lightning Bolt"));
    }

    @Test
    @DisplayName("Should return empty list when text not found")
    void shouldReturnEmptyListWhenTextNotFound() throws Exception {
        when(service.findByTextContaining("nonexistent")).thenReturn(List.of());

        mockMvc.perform(get("/api/magic/text-contains/nonexistent"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }
}
