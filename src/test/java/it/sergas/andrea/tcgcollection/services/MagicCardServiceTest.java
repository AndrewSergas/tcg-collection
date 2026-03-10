package it.sergas.andrea.tcgcollection.services;

import it.sergas.andrea.tcgcollection.fixtures.MagicCardDTOFixtures;
import it.sergas.andrea.tcgcollection.fixtures.MagicCardFixtures;
import it.sergas.andrea.tcgcollection.mappers.MagicCardMapper;
import it.sergas.andrea.tcgcollection.repositories.MagicCardRepository;
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
@DisplayName("MagicCardService Tests")
class MagicCardServiceTest {

    @Mock private MagicCardMapper mapper;
    @Mock private MagicCardRepository repository;
    @InjectMocks private MagicCardService systemUnderTest;

    @Test
    @DisplayName("findByType should find the Instant type Lightning Bolt card")
    void findByType_shouldFindTheInstantTypeLightningBolt() {
        val entity = MagicCardFixtures.lightningBolt();
        val dto = MagicCardDTOFixtures.lightningBolt();

        when(repository.findByType("Instant")).thenReturn(List.of(entity));
        when(mapper.toDTO(entity)).thenReturn(dto);

        assertThat(systemUnderTest.findByType("Instant")).containsExactly(dto);
    }

    @Test
    @DisplayName("findByType should return an empty list when no cards are found by type")
    void findByType_shouldReturnEmptyList_whenNoCardsAreFoundByType() {
        when(repository.findByType("Planeswalker")).thenReturn(List.of());
        assertThat(systemUnderTest.findByType("Planeswalker")).isEmpty();
    }

    @Test
    @DisplayName("findByColor should find the Red color Lightning Bolt card")
    void findByColor_shouldFindTheRedColorLightningBolt() {
        val entity = MagicCardFixtures.lightningBolt();
        val dto = MagicCardDTOFixtures.lightningBolt();

        when(repository.findByColor("Red")).thenReturn(List.of(entity));
        when(mapper.toDTO(entity)).thenReturn(dto);

        assertThat(systemUnderTest.findByColor("Red")).containsExactly(dto);
    }

    @Test
    @DisplayName("findByColor should return an empty list when no cards are found by color")
    void findByColor_shouldReturnEmptyList_whenNoCardsAreFoundByColor() {
        when(repository.findByColor("Purple")).thenReturn(List.of());
        assertThat(systemUnderTest.findByColor("Purple")).isEmpty();
    }

    @Test
    @DisplayName("findByTextContaining should find cards containing 'damage' text")
    void findByTextContaining_shouldFindCardsContainingDamageText() {
        val entity = MagicCardFixtures.lightningBolt();
        val dto = MagicCardDTOFixtures.lightningBolt();

        when(repository.findByTextContaining("damage")).thenReturn(List.of(entity));
        when(mapper.toDTO(entity)).thenReturn(dto);

        assertThat(systemUnderTest.findByTextContaining("damage")).containsExactly(dto);
    }

    @Test
    @DisplayName("findByTextContaining should return an empty list when no cards are found by text")
    void findByTextContaining_shouldReturnEmptyList_whenNoCardsAreFoundByText() {
        when(repository.findByTextContaining("nonexistent")).thenReturn(List.of());
        assertThat(systemUnderTest.findByTextContaining("nonexistent")).isEmpty();
    }

    @Test
    @DisplayName("findAll should find all cards")
    void findAll_shouldFindAllCards() {
        val entity = MagicCardFixtures.lightningBolt();
        val dto = MagicCardDTOFixtures.lightningBolt();

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
