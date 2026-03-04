package it.sergas.andrea.tcgcollection.services;

import it.sergas.andrea.tcgcollection.fixtures.PokemonCardDTOFixtures;
import it.sergas.andrea.tcgcollection.fixtures.PokemonCardFixtures;
import it.sergas.andrea.tcgcollection.mappers.PokemonCardMapper;
import it.sergas.andrea.tcgcollection.repositories.PokemonCardRepository;
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
@DisplayName("PokemonCardService Tests")
class PokemonCardServiceTest {

    @Mock private PokemonCardMapper mapper;
    @Mock private PokemonCardRepository repository;
    @InjectMocks private PokemonCardService service;

    @Test
    @DisplayName("Should find cards by rarity")
    void shouldFindCardsByRarity() {
        val entity = PokemonCardFixtures.pikachu();
        val dto = PokemonCardDTOFixtures.pikachu();

        when(repository.findByRarity("Common")).thenReturn(List.of(entity));
        when(mapper.toDTO(entity)).thenReturn(dto);

        assertThat(service.findByRarity("Common")).containsExactly(dto);
    }

    @Test
    @DisplayName("Should return empty list when no cards found by rarity")
    void shouldReturnEmptyListWhenNoCardsByRarity() {
        when(repository.findByRarity("Ultra Rare")).thenReturn(List.of());
        assertThat(service.findByRarity("Ultra Rare")).isEmpty();
    }

    @Test
    @DisplayName("Should find cards by type")
    void shouldFindCardsByType() {
        val entity = PokemonCardFixtures.pikachu();
        val dto = PokemonCardDTOFixtures.pikachu();

        when(repository.findByType("Lightning")).thenReturn(List.of(entity));
        when(mapper.toDTO(entity)).thenReturn(dto);

        assertThat(service.findByType("Lightning")).containsExactly(dto);
    }

    @Test
    @DisplayName("Should return empty list when no cards found by type")
    void shouldReturnEmptyListWhenNoCardsByType() {
        when(repository.findByType("Dragon")).thenReturn(List.of());
        assertThat(service.findByType("Dragon")).isEmpty();
    }

    @Test
    @DisplayName("Should find cards with attacks")
    void shouldFindCardsWithAttacks() {
        val pikachu = PokemonCardFixtures.pikachu();
        val charizard = PokemonCardFixtures.charizard();

        val pikachuDTO = PokemonCardDTOFixtures.pikachu();
        val charizardDTO = PokemonCardDTOFixtures.charizard();

        when(repository.findCardsWithAttacks()).thenReturn(List.of(pikachu, charizard));
        when(mapper.toDTO(pikachu)).thenReturn(pikachuDTO);
        when(mapper.toDTO(charizard)).thenReturn(charizardDTO);

        assertThat(service.findCardsWithAttacks()).containsExactly(pikachuDTO, charizardDTO);
    }

    @Test
    @DisplayName("Should return empty list when no cards with attacks")
    void shouldReturnEmptyListWhenNoCardsWithAttacks() {
        when(repository.findCardsWithAttacks()).thenReturn(List.of());
        assertThat(service.findCardsWithAttacks()).isEmpty();
    }

    @Test
    @DisplayName("Should find all cards")
    void shouldFindAllCards() {
        val entity = PokemonCardFixtures.pikachu();
        val dto = PokemonCardDTOFixtures.pikachu();

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
