package it.sergas.andrea.tcgcollection.controllers;

import it.sergas.andrea.tcgcollection.fixtures.YugiohCardDTOFixtures;
import it.sergas.andrea.tcgcollection.services.YugiohCardService;
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
@DisplayName("YugiohCardController Tests")
class YugiohCardControllerTest {

    @Autowired private MockMvc mockMvc;
    @MockitoBean private YugiohCardService systemUnderTest;

    @Test
    @DisplayName("getAllCards should return the Dark Magician card")
    void getAllCards_shouldReturnTheDarkMagicianCard() throws Exception {
        val dto = YugiohCardDTOFixtures.darkMagician();
        when(systemUnderTest.findAll()).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/yugioh"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Dark Magician"))
                .andExpect(jsonPath("$[0].cardType").value("Monster"));
    }

    @Test
    @DisplayName("getAllCards should return an empty list when no cards are found")
    void getAllCards_shouldReturnEmptyList_whenNoCardsAreFound() throws Exception {
        when(systemUnderTest.findAll()).thenReturn(List.of());

        mockMvc.perform(get("/api/yugioh"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    @DisplayName("findByCardType should find the Monster type Dark Magician card")
    void findByCardType_shouldFindTheMonsterTypeDarkMagician() throws Exception {
        val dto = YugiohCardDTOFixtures.darkMagician();
        when(systemUnderTest.findByCardType("Monster")).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/yugioh/card-type/Monster"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Dark Magician"))
                .andExpect(jsonPath("$[0].cardType").value("Monster"));
    }

    @Test
    @DisplayName("findByCardType should return an empty list when no cards are found by card type")
    void findByCardType_shouldReturnEmptyList_whenNoCardsAreFoundByCardType() throws Exception {
        when(systemUnderTest.findByCardType("Ritual")).thenReturn(List.of());

        mockMvc.perform(get("/api/yugioh/card-type/Ritual"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    @DisplayName("findByAttackGreaterThan should find the Blue-Eyes White Dragon card with attack greater than 2000")
    void findByAttackGreaterThan_shouldFindBlueEyesWithAttackGreaterThan2000() throws Exception {
        val dto = YugiohCardDTOFixtures.blueEyesWhiteDragon();
        when(systemUnderTest.findByAttackGreaterThan(2000)).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/yugioh/attack-greater-than/2000"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Blue-Eyes White Dragon"))
                .andExpect(jsonPath("$[0].attack").value(3000));
    }

    @Test
    @DisplayName("findByAttackGreaterThan should return an empty list when no cards have attack greater than threshold")
    void findByAttackGreaterThan_shouldReturnEmptyList_whenNoCardsAboveThreshold() throws Exception {
        when(systemUnderTest.findByAttackGreaterThan(9999)).thenReturn(List.of());

        mockMvc.perform(get("/api/yugioh/attack-greater-than/9999"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    @DisplayName("findCardsWithDefenseGreaterThanAttack should find the Wall of Illusion card")
    void findCardsWithDefenseGreaterThanAttack_shouldFindWallOfIllusion() throws Exception {
        val dto = YugiohCardDTOFixtures.wallOfIllusion();
        when(systemUnderTest.findCardsWithDefenseGreaterThanAttack()).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/yugioh/defense-greater-than-attack"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Wall of Illusion"))
                .andExpect(jsonPath("$[0].defense").value(1850));
    }

    @Test
    @DisplayName("findCardsWithDefenseGreaterThanAttack should return an empty list when no cards have defense greater than attack")
    void findCardsWithDefenseGreaterThanAttack_shouldReturnEmptyList_whenNoCardsFound() throws Exception {
        when(systemUnderTest.findCardsWithDefenseGreaterThanAttack()).thenReturn(List.of());

        mockMvc.perform(get("/api/yugioh/defense-greater-than-attack"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }
}
