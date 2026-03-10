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
    @DisplayName("getAllCards should return the Lightning Bolt card")
    void getAllCards_shouldReturnTheLightningBoltCard() throws Exception {
        val dto = MagicCardDTOFixtures.lightningBolt();
        when(service.findAll()).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/magic"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Lightning Bolt"))
                .andExpect(jsonPath("$[0].type").value("Instant"));
    }

    @Test
    @DisplayName("getAllCards should return an empty list when no cards are found")
    void getAllCards_shouldReturnEmptyList_whenNoCardsAreFound() throws Exception {
        when(service.findAll()).thenReturn(List.of());

        mockMvc.perform(get("/api/magic"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    @DisplayName("findByType should find the Artifact type Black Lotus card")
    void findByType_shouldFindTheArtifactTypeBlackLotus() throws Exception {
        val dto = MagicCardDTOFixtures.blackLotus();
        when(service.findByType("Artifact")).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/magic/type/Artifact"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Black Lotus"))
                .andExpect(jsonPath("$[0].type").value("Artifact"));
    }

    @Test
    @DisplayName("findByType should return an empty list when no cards are found by type")
    void findByType_shouldReturnEmptyList_whenNoCardsAreFoundByType() throws Exception {
        when(service.findByType("Planeswalker")).thenReturn(List.of());

        mockMvc.perform(get("/api/magic/type/Planeswalker"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    @DisplayName("findByColor should find the Red color Lightning Bolt card")
    void findByColor_shouldFindTheRedColorLightningBolt() throws Exception {
        val dto = MagicCardDTOFixtures.lightningBolt();
        when(service.findByColor("Red")).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/magic/color/Red"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Lightning Bolt"))
                .andExpect(jsonPath("$[0].colors[0]").value("Red"));
    }

    @Test
    @DisplayName("findByColor should return an empty list when no cards are found by color")
    void findByColor_shouldReturnEmptyList_whenNoCardsAreFoundByColor() throws Exception {
        when(service.findByColor("Purple")).thenReturn(List.of());

        mockMvc.perform(get("/api/magic/color/Purple"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    @DisplayName("findByTextContaining should find cards containing 'damage' text")
    void findByTextContaining_shouldFindCardsContainingDamageText() throws Exception {
        val dto = MagicCardDTOFixtures.lightningBolt();
        when(service.findByTextContaining("damage")).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/magic/text-contains/damage"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Lightning Bolt"));
    }

    @Test
    @DisplayName("findByTextContaining should return an empty list when no cards are found by text")
    void findByTextContaining_shouldReturnEmptyList_whenNoCardsAreFoundByText() throws Exception {
        when(service.findByTextContaining("nonexistent")).thenReturn(List.of());

        mockMvc.perform(get("/api/magic/text-contains/nonexistent"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }
}
