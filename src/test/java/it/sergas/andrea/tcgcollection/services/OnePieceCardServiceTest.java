package it.sergas.andrea.tcgcollection.services;

import it.sergas.andrea.tcgcollection.fixtures.OnePieceCardDTOFixtures;
import it.sergas.andrea.tcgcollection.fixtures.OnePieceCardFixtures;
import it.sergas.andrea.tcgcollection.mappers.OnePieceCardMapper;
import it.sergas.andrea.tcgcollection.repositories.OnePieceCardRepository;
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
@DisplayName("OnePieceCardService Tests")
class OnePieceCardServiceTest {

    @Mock private OnePieceCardMapper mapper;
    @Mock private OnePieceCardRepository repository;
    @InjectMocks private OnePieceCardService systemUnderTest;

    @Test
    @DisplayName("findByColor should find the Red color Luffy card")
    void findByColor_shouldFindTheRedColorLuffy() {
        val entity = OnePieceCardFixtures.luffy();
        val dto = OnePieceCardDTOFixtures.luffy();

        when(repository.findByColor("Red")).thenReturn(List.of(entity));
        when(mapper.toDTO(entity)).thenReturn(dto);

        assertThat(systemUnderTest.findByColor("Red")).containsExactly(dto);
    }

    @Test
    @DisplayName("findByColor should return an empty list when no cards are found by color")
    void findByColor_shouldReturnEmptyList_whenNoCardsAreFoundByColor() {
        when(repository.findByColor("Black")).thenReturn(List.of());
        assertThat(systemUnderTest.findByColor("Black")).isEmpty();
    }

    @Test
    @DisplayName("findByPowerGreaterThan should find the Luffy card with power greater than 4000")
    void findByPowerGreaterThan_shouldFindLuffyWithPowerGreaterThan4000() {
        val entity = OnePieceCardFixtures.luffy();
        val dto = OnePieceCardDTOFixtures.luffy();

        when(repository.findByPowerGreaterThan(4000)).thenReturn(List.of(entity));
        when(mapper.toDTO(entity)).thenReturn(dto);

        assertThat(systemUnderTest.findByPowerGreaterThan(4000)).containsExactly(dto);
    }

    @Test
    @DisplayName("findByPowerGreaterThan should return an empty list when no cards have power greater than threshold")
    void findByPowerGreaterThan_shouldReturnEmptyList_whenNoCardsAboveThreshold() {
        when(repository.findByPowerGreaterThan(99999)).thenReturn(List.of());
        assertThat(systemUnderTest.findByPowerGreaterThan(99999)).isEmpty();
    }

    @Test
    @DisplayName("findAll should find all cards")
    void findAll_shouldFindAllCards() {
        val entity = OnePieceCardFixtures.luffy();
        val dto = OnePieceCardDTOFixtures.luffy();

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
