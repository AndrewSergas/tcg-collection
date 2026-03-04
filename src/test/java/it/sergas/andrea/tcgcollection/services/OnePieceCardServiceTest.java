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
    @InjectMocks private OnePieceCardService service;

    @Test
    @DisplayName("Should find cards by color")
    void shouldFindCardsByColor() {
        val entity = OnePieceCardFixtures.luffy();
        val dto = OnePieceCardDTOFixtures.luffy();

        when(repository.findByColor("Red")).thenReturn(List.of(entity));
        when(mapper.toDTO(entity)).thenReturn(dto);

        assertThat(service.findByColor("Red")).containsExactly(dto);
    }

    @Test
    @DisplayName("Should return empty list when no cards found by color")
    void shouldReturnEmptyListWhenNoCardsByColor() {
        when(repository.findByColor("Black")).thenReturn(List.of());
        assertThat(service.findByColor("Black")).isEmpty();
    }

    @Test
    @DisplayName("Should find cards by power greater than")
    void shouldFindCardsByPowerGreaterThan() {
        val entity = OnePieceCardFixtures.luffy();
        val dto = OnePieceCardDTOFixtures.luffy();

        when(repository.findByPowerGreaterThan(4000)).thenReturn(List.of(entity));
        when(mapper.toDTO(entity)).thenReturn(dto);

        assertThat(service.findByPowerGreaterThan(4000)).containsExactly(dto);
    }

    @Test
    @DisplayName("Should return empty list when no cards with power greater than")
    void shouldReturnEmptyListWhenNoCardsByPowerGreaterThan() {
        when(repository.findByPowerGreaterThan(99999)).thenReturn(List.of());
        assertThat(service.findByPowerGreaterThan(99999)).isEmpty();
    }

    @Test
    @DisplayName("Should find all cards")
    void shouldFindAllCards() {
        val entity = OnePieceCardFixtures.luffy();
        val dto = OnePieceCardDTOFixtures.luffy();

        when(repository.findAll()).thenReturn(List.of(entity));
        when(mapper.toDTO(entity)).thenReturn(dto);

        assertThat(service.findAll()).containsExactly(dto);
    }

    @Test
    @DisplayName("Should return empty list when no cards found")
    void shouldReturnEmptyListWhenNoCards() {
        when(repository.findAll()).thenReturn(List.of());
        assertThat(service.findAll()).isEmpty();
    }
}
