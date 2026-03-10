package it.sergas.andrea.tcgcollection.services;

import it.sergas.andrea.tcgcollection.fixtures.YugiohCardDTOFixtures;
import it.sergas.andrea.tcgcollection.fixtures.YugiohCardFixtures;
import it.sergas.andrea.tcgcollection.mappers.YugiohCardMapper;
import it.sergas.andrea.tcgcollection.repositories.YugiohCardRepository;
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
@DisplayName("YugiohCardService Tests")
class YugiohCardServiceTest {

    @Mock private YugiohCardMapper mapper;
    @Mock private YugiohCardRepository repository;
    @InjectMocks private YugiohCardService systemUnderTest;

    @Test
    @DisplayName("findByCardType should find the Monster type Dark Magician card")
    void findByCardType_shouldFindTheMonsterTypeDarkMagician() {
        val entity = YugiohCardFixtures.darkMagician();
        val dto = YugiohCardDTOFixtures.darkMagician();

        when(repository.findByCardType("Monster")).thenReturn(List.of(entity));
        when(mapper.toDTO(entity)).thenReturn(dto);

        assertThat(systemUnderTest.findByCardType("Monster")).containsExactly(dto);
    }

    @Test
    @DisplayName("findByCardType should return an empty list when no cards are found by card type")
    void findByCardType_shouldReturnEmptyList_whenNoCardsAreFoundByCardType() {
        when(repository.findByCardType("Ritual")).thenReturn(List.of());
        assertThat(systemUnderTest.findByCardType("Ritual")).isEmpty();
    }

    @Test
    @DisplayName("findByAttackGreaterThan should find the Blue-Eyes White Dragon card with attack greater than 2000")
    void findByAttackGreaterThan_shouldFindBlueEyesWithAttackGreaterThan2000() {
        val entity = YugiohCardFixtures.blueEyesWhiteDragon();
        val dto = YugiohCardDTOFixtures.blueEyesWhiteDragon();

        when(repository.findByAttackGreaterThan(2000)).thenReturn(List.of(entity));
        when(mapper.toDTO(entity)).thenReturn(dto);

        assertThat(systemUnderTest.findByAttackGreaterThan(2000)).containsExactly(dto);
    }

    @Test
    @DisplayName("findByAttackGreaterThan should return an empty list when no cards have attack greater than threshold")
    void findByAttackGreaterThan_shouldReturnEmptyList_whenNoCardsAboveThreshold() {
        when(repository.findByAttackGreaterThan(9999)).thenReturn(List.of());
        assertThat(systemUnderTest.findByAttackGreaterThan(9999)).isEmpty();
    }

    @Test
    @DisplayName("findCardsWithDefenseGreaterThanAttack should find the Wall of Illusion card")
    void findCardsWithDefenseGreaterThanAttack_shouldFindWallOfIllusion() {
        val entity = YugiohCardFixtures.wallOfIllusion();
        val dto = YugiohCardDTOFixtures.wallOfIllusion();

        when(repository.findCardsWithDefenseGreaterThanAttack()).thenReturn(List.of(entity));
        when(mapper.toDTO(entity)).thenReturn(dto);

        assertThat(systemUnderTest.findCardsWithDefenseGreaterThanAttack()).containsExactly(dto);
    }

    @Test
    @DisplayName("findCardsWithDefenseGreaterThanAttack should return an empty list when no cards have defense greater than attack")
    void findCardsWithDefenseGreaterThanAttack_shouldReturnEmptyList_whenNoCardsFound() {
        when(repository.findCardsWithDefenseGreaterThanAttack()).thenReturn(List.of());
        assertThat(systemUnderTest.findCardsWithDefenseGreaterThanAttack()).isEmpty();
    }

    @Test
    @DisplayName("findAll should find all cards")
    void findAll_shouldFindAllCards() {
        val entity = YugiohCardFixtures.darkMagician();
        val dto = YugiohCardDTOFixtures.darkMagician();

        when(repository.findAll()).thenReturn(List.of(entity));
        when(mapper.toDTO(entity)).thenReturn(dto);

        assertThat(systemUnderTest.findAll()).containsExactly(dto);
    }

    @Test
    @DisplayName("findAll should return an empty list when no cards are found")
    void findAll_shouldReturnEmptyList_whenNoCardsAreFound() {
        when(repository.findAll()).thenReturn(List.of());
        assertThat(systemUnderTest.findAll()).isEmpty();
    }
}
