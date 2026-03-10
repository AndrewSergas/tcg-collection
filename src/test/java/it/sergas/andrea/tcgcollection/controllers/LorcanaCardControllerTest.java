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
    @MockitoBean private LorcanaCardService systemUnderTest;

    @Test
    @DisplayName("getAllCards should return the Elsa card")
    void getAllCards_shouldReturnTheElsaCard() throws Exception {
        val dto = LorcanaCardDTOFixtures.elsa();
        when(systemUnderTest.findAll()).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/lorcana"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Elsa - Snow Queen"))
                .andExpect(jsonPath("$[0].cardType").value("Character"));
    }

    @Test
    @DisplayName("getAllCards should return an empty list when no cards are found")
    void getAllCards_shouldReturnEmptyList_whenNoCardsAreFound() throws Exception {
        when(systemUnderTest.findAll()).thenReturn(List.of());

        mockMvc.perform(get("/api/lorcana"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    @DisplayName("findByInkColor should find the Steel ink Mickey card")
    void findByInkColor_shouldFindTheSteelInkMickey() throws Exception {
        val dto = LorcanaCardDTOFixtures.mickey();
        when(systemUnderTest.findByInkColor("Steel")).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/lorcana/ink-color/Steel"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Mickey Mouse - Brave Little Tailor"))
                .andExpect(jsonPath("$[0].inkColors[0]").value("Steel"));
    }

    @Test
    @DisplayName("findByInkColor should return an empty list when no cards are found by ink color")
    void findByInkColor_shouldReturnEmptyList_whenNoCardsAreFoundByInkColor() throws Exception {
        when(systemUnderTest.findByInkColor("Ruby")).thenReturn(List.of());

        mockMvc.perform(get("/api/lorcana/ink-color/Ruby"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    @DisplayName("findByFranchiseTitle should find the Frozen franchise Elsa card")
    void findByFranchiseTitle_shouldFindTheFrozenFranchiseElsa() throws Exception {
        val dto = LorcanaCardDTOFixtures.elsa();
        when(systemUnderTest.findByFranchiseTitle("Frozen")).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/lorcana/franchise/Frozen"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Elsa - Snow Queen"))
                .andExpect(jsonPath("$[0].franchiseTitle").value("Frozen"));
    }

    @Test
    @DisplayName("findByFranchiseTitle should return an empty list when no cards are found by franchise title")
    void findByFranchiseTitle_shouldReturnEmptyList_whenNoCardsAreFoundByFranchiseTitle() throws Exception {
        when(systemUnderTest.findByFranchiseTitle("Aladdin")).thenReturn(List.of());

        mockMvc.perform(get("/api/lorcana/franchise/Aladdin"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }
}
