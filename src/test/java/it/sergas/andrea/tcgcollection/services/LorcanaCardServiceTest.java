package it.sergas.andrea.tcgcollection.services;

import it.sergas.andrea.tcgcollection.fixtures.LorcanaCardDTOFixtures;
import it.sergas.andrea.tcgcollection.fixtures.LorcanaCardFixtures;
import it.sergas.andrea.tcgcollection.mappers.LorcanaCardMapper;
import it.sergas.andrea.tcgcollection.repositories.LorcanaCardRepository;
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
@DisplayName("LorcanaCardService Tests")
class LorcanaCardServiceTest {

    @Mock private LorcanaCardMapper mapper;
    @Mock private LorcanaCardRepository repository;
    @InjectMocks private LorcanaCardService service;

    @Test
    @DisplayName("Should find cards by ink color")
    void shouldFindCardsByInkColor() {
        val entity = LorcanaCardFixtures.mickey();
        val dto = LorcanaCardDTOFixtures.mickey();

        when(repository.findByInkColor("Steel")).thenReturn(List.of(entity));
        when(mapper.toDTO(entity)).thenReturn(dto);

        assertThat(service.findByInkColor("Steel")).containsExactly(dto);
    }

    @Test
    @DisplayName("Should return empty list when no cards found by ink color")
    void shouldReturnEmptyListWhenNoCardsByInkColor() {
        when(repository.findByInkColor("Ruby")).thenReturn(List.of());
        assertThat(service.findByInkColor("Ruby")).isEmpty();
    }

    @Test
    @DisplayName("Should find cards by franchise title")
    void shouldFindCardsByFranchiseTitle() {
        val entity = LorcanaCardFixtures.elsa();
        val dto = LorcanaCardDTOFixtures.elsa();

        when(repository.findByFranchiseTitle("Frozen")).thenReturn(List.of(entity));
        when(mapper.toDTO(entity)).thenReturn(dto);

        assertThat(service.findByFranchiseTitle("Frozen")).containsExactly(dto);
    }

    @Test
    @DisplayName("Should return empty list when no cards found by franchise title")
    void shouldReturnEmptyListWhenNoCardsByFranchiseTitle() {
        when(repository.findByFranchiseTitle("Aladdin")).thenReturn(List.of());
        assertThat(service.findByFranchiseTitle("Aladdin")).isEmpty();
    }

    @Test
    @DisplayName("Should find all cards")
    void shouldFindAllCards() {
        val entity = LorcanaCardFixtures.elsa();
        val dto = LorcanaCardDTOFixtures.elsa();

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
