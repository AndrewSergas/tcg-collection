package it.sergas.andrea.tcgcollection.controllers;

import it.sergas.andrea.tcgcollection.fixtures.LorcanaCardDTOFixtures;
import it.sergas.andrea.tcgcollection.services.LorcanaCardService;
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
@DisplayName("LorcanaCardController Tests")
class LorcanaCardControllerTest {

    @Autowired private MockMvc mockMvc;
    @MockitoBean private LorcanaCardService service;

    @Test
    @DisplayName("Should get all cards")
    void shouldGetAllCards() throws Exception {
        val dto = LorcanaCardDTOFixtures.elsa();
        when(service.findAll()).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/lorcana"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Elsa - Snow Queen"))
                .andExpect(jsonPath("$[0].cardType").value("Character"));
    }

    @Test
    @DisplayName("Should return empty list when no cards")
    void shouldReturnEmptyListWhenNoCards() throws Exception {
        when(service.findAll()).thenReturn(List.of());

        mockMvc.perform(get("/api/lorcana"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    @DisplayName("Should find cards by ink color")
    void shouldFindCardsByInkColor() throws Exception {
        val dto = LorcanaCardDTOFixtures.mickey();
        when(service.findByInkColor("Steel")).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/lorcana/ink-color/Steel"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Mickey Mouse - Brave Little Tailor"))
                .andExpect(jsonPath("$[0].inkColors[0]").value("Steel"));
    }

    @Test
    @DisplayName("Should return empty list for non-existent ink color")
    void shouldReturnEmptyListForNonExistentInkColor() throws Exception {
        when(service.findByInkColor("Ruby")).thenReturn(List.of());

        mockMvc.perform(get("/api/lorcana/ink-color/Ruby"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    @DisplayName("Should find cards by franchise title")
    void shouldFindCardsByFranchiseTitle() throws Exception {
        val dto = LorcanaCardDTOFixtures.elsa();
        when(service.findByFranchiseTitle("Frozen")).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/lorcana/franchise/Frozen"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Elsa - Snow Queen"))
                .andExpect(jsonPath("$[0].franchiseTitle").value("Frozen"));
    }

    @Test
    @DisplayName("Should return empty list for non-existent franchise title")
    void shouldReturnEmptyListForNonExistentFranchiseTitle() throws Exception {
        when(service.findByFranchiseTitle("Aladdin")).thenReturn(List.of());

        mockMvc.perform(get("/api/lorcana/franchise/Aladdin"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }
}
