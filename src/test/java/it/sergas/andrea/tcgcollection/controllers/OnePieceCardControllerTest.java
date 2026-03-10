package it.sergas.andrea.tcgcollection.controllers;

import it.sergas.andrea.tcgcollection.fixtures.OnePieceCardDTOFixtures;
import it.sergas.andrea.tcgcollection.services.OnePieceCardService;
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
@DisplayName("OnePieceCardController Tests")
class OnePieceCardControllerTest {

    @Autowired private MockMvc mockMvc;
    @MockitoBean private OnePieceCardService systemUnderTest;

    @Test
    @DisplayName("getAllCards should return the Luffy card")
    void getAllCards_shouldReturnTheLuffyCard() throws Exception {
        val dto = OnePieceCardDTOFixtures.luffy();
        when(systemUnderTest.findAll()).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/onepiece"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Monkey D. Luffy"))
                .andExpect(jsonPath("$[0].cardType").value("Leader"));
    }

    @Test
    @DisplayName("getAllCards should return an empty list when no cards are found")
    void getAllCards_shouldReturnEmptyList_whenNoCardsAreFound() throws Exception {
        when(systemUnderTest.findAll()).thenReturn(List.of());

        mockMvc.perform(get("/api/onepiece"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    @DisplayName("findByColor should find the Red color Luffy card")
    void findByColor_shouldFindTheRedColorLuffy() throws Exception {
        val dto = OnePieceCardDTOFixtures.luffy();
        when(systemUnderTest.findByColor("Red")).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/onepiece/color/Red"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Monkey D. Luffy"))
                .andExpect(jsonPath("$[0].colors[0]").value("Red"));
    }

    @Test
    @DisplayName("findByColor should return an empty list when no cards are found by color")
    void findByColor_shouldReturnEmptyList_whenNoCardsAreFoundByColor() throws Exception {
        when(systemUnderTest.findByColor("Black")).thenReturn(List.of());

        mockMvc.perform(get("/api/onepiece/color/Black"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    @DisplayName("findByPowerGreaterThan should find the Luffy card with power greater than 4000")
    void findByPowerGreaterThan_shouldFindLuffyWithPowerGreaterThan4000() throws Exception {
        val dto = OnePieceCardDTOFixtures.luffy();
        when(systemUnderTest.findByPowerGreaterThan(4000)).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/onepiece/power-greater-than/4000"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Monkey D. Luffy"))
                .andExpect(jsonPath("$[0].power").value(5000));
    }

    @Test
    @DisplayName("findByPowerGreaterThan should return an empty list when no cards have power greater than threshold")
    void findByPowerGreaterThan_shouldReturnEmptyList_whenNoCardsAboveThreshold() throws Exception {
        when(systemUnderTest.findByPowerGreaterThan(99999)).thenReturn(List.of());

        mockMvc.perform(get("/api/onepiece/power-greater-than/99999"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }
}
