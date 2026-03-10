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
    @InjectMocks private LorcanaCardService systemUnderTest;

    @Test
    @DisplayName("findByInkColor should find the Steel ink Mickey card")
    void findByInkColor_shouldFindTheSteelInkMickey() {
        val entity = LorcanaCardFixtures.mickey();
        val dto = LorcanaCardDTOFixtures.mickey();

        when(repository.findByInkColor("Steel")).thenReturn(List.of(entity));
        when(mapper.toDTO(entity)).thenReturn(dto);

        assertThat(systemUnderTest.findByInkColor("Steel")).containsExactly(dto);
    }

    @Test
    @DisplayName("findByInkColor should return an empty list when no cards are found by ink color")
    void findByInkColor_shouldReturnEmptyList_whenNoCardsAreFoundByInkColor() {
        when(repository.findByInkColor("Ruby")).thenReturn(List.of());
        assertThat(systemUnderTest.findByInkColor("Ruby")).isEmpty();
    }

    @Test
    @DisplayName("findByFranchiseTitle should find the Frozen franchise Elsa card")
    void findByFranchiseTitle_shouldFindTheFrozenFranchiseElsa() {
        val entity = LorcanaCardFixtures.elsa();
        val dto = LorcanaCardDTOFixtures.elsa();

        when(repository.findByFranchiseTitle("Frozen")).thenReturn(List.of(entity));
        when(mapper.toDTO(entity)).thenReturn(dto);

        assertThat(systemUnderTest.findByFranchiseTitle("Frozen")).containsExactly(dto);
    }

    @Test
    @DisplayName("findByFranchiseTitle should return an empty list when no cards are found by franchise title")
    void findByFranchiseTitle_shouldReturnEmptyList_whenNoCardsAreFoundByFranchiseTitle() {
        when(repository.findByFranchiseTitle("Aladdin")).thenReturn(List.of());
        assertThat(systemUnderTest.findByFranchiseTitle("Aladdin")).isEmpty();
    }

    @Test
    @DisplayName("findAll should find all cards")
    void findAll_shouldFindAllCards() {
        val entity = LorcanaCardFixtures.elsa();
        val dto = LorcanaCardDTOFixtures.elsa();

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
