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
    @InjectMocks private MagicCardService service;

    @Test
    @DisplayName("Should find cards by type")
    void shouldFindCardsByType() {
        val entity = MagicCardFixtures.lightningBolt();
        val dto = MagicCardDTOFixtures.lightningBolt();

        when(repository.findByType("Instant")).thenReturn(List.of(entity));
        when(mapper.toDTO(entity)).thenReturn(dto);

        assertThat(service.findByType("Instant")).containsExactly(dto);
    }

    @Test
    @DisplayName("Should return empty list when no cards found by type")
    void shouldReturnEmptyListWhenNoCardsByType() {
        when(repository.findByType("Planeswalker")).thenReturn(List.of());
        assertThat(service.findByType("Planeswalker")).isEmpty();
    }

    @Test
    @DisplayName("Should find cards by color")
    void shouldFindCardsByColor() {
        val entity = MagicCardFixtures.lightningBolt();
        val dto = MagicCardDTOFixtures.lightningBolt();

        when(repository.findByColor("Red")).thenReturn(List.of(entity));
        when(mapper.toDTO(entity)).thenReturn(dto);

        assertThat(service.findByColor("Red")).containsExactly(dto);
    }

    @Test
    @DisplayName("Should return empty list when no cards found by color")
    void shouldReturnEmptyListWhenNoCardsByColor() {
        when(repository.findByColor("Purple")).thenReturn(List.of());
        assertThat(service.findByColor("Purple")).isEmpty();
    }

    @Test
    @DisplayName("Should find cards by text containing")
    void shouldFindCardsByTextContaining() {
        val entity = MagicCardFixtures.lightningBolt();
        val dto = MagicCardDTOFixtures.lightningBolt();

        when(repository.findByTextContaining("damage")).thenReturn(List.of(entity));
        when(mapper.toDTO(entity)).thenReturn(dto);

        assertThat(service.findByTextContaining("damage")).containsExactly(dto);
    }

    @Test
    @DisplayName("Should return empty list when no cards found by text containing")
    void shouldReturnEmptyListWhenNoCardsByTextContaining() {
        when(repository.findByTextContaining("nonexistent")).thenReturn(List.of());
        assertThat(service.findByTextContaining("nonexistent")).isEmpty();
    }

    @Test
    @DisplayName("Should find all cards")
    void shouldFindAllCards() {
        val entity = MagicCardFixtures.lightningBolt();
        val dto = MagicCardDTOFixtures.lightningBolt();

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
