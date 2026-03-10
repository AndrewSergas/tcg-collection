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
    @InjectMocks private PokemonCardService systemUnderTest;

    @Test
    @DisplayName("findByRarity should find the common Pikachu card")
    void findByRarity_shouldFindTheCommonPikachu() {
        val entity = PokemonCardFixtures.pikachu();
        val dto = PokemonCardDTOFixtures.pikachu();

        when(repository.findByRarity("Common")).thenReturn(List.of(entity));
        when(mapper.toDTO(entity)).thenReturn(dto);

        assertThat(systemUnderTest.findByRarity("Common")).containsExactly(dto);
    }

    @Test
    @DisplayName("findByRarity should return an empty list when no cards are found by rarity")
    void findByRarity_shouldReturnEmptyList_whenNoCardsAreFoundByRarity() {
        when(repository.findByRarity("Ultra Rare")).thenReturn(List.of());
        assertThat(systemUnderTest.findByRarity("Ultra Rare")).isEmpty();
    }

    @Test
    @DisplayName("findByType should find the Lightning type Pikachu card")
    void findByType_shouldFindTheLightningTypePikachu() {
        val entity = PokemonCardFixtures.pikachu();
        val dto = PokemonCardDTOFixtures.pikachu();

        when(repository.findByType("Lightning")).thenReturn(List.of(entity));
        when(mapper.toDTO(entity)).thenReturn(dto);

        assertThat(systemUnderTest.findByType("Lightning")).containsExactly(dto);
    }

    @Test
    @DisplayName("findByType should return an empty list when no cards are found by type")
    void findByType_shouldReturnEmptyList_whenNoCardsAreFoundByType() {
        when(repository.findByType("Dragon")).thenReturn(List.of());
        assertThat(systemUnderTest.findByType("Dragon")).isEmpty();
    }

    @Test
    @DisplayName("findCardsWithAttacks should find Pikachu and Charizard cards")
    void findCardsWithAttacks_shouldFindPikachuAndCharizard() {
        val pikachu = PokemonCardFixtures.pikachu();
        val charizard = PokemonCardFixtures.charizard();

        val pikachuDTO = PokemonCardDTOFixtures.pikachu();
        val charizardDTO = PokemonCardDTOFixtures.charizard();

        when(repository.findCardsWithAttacks()).thenReturn(List.of(pikachu, charizard));
        when(mapper.toDTO(pikachu)).thenReturn(pikachuDTO);
        when(mapper.toDTO(charizard)).thenReturn(charizardDTO);

        assertThat(systemUnderTest.findCardsWithAttacks()).containsExactly(pikachuDTO, charizardDTO);
    }

    @Test
    @DisplayName("findCardsWithAttacks should return an empty list when no cards have attacks")
    void findCardsWithAttacks_shouldReturnEmptyList_whenNoCardsHaveAttacks() {
        when(repository.findCardsWithAttacks()).thenReturn(List.of());
        assertThat(systemUnderTest.findCardsWithAttacks()).isEmpty();
    }

    @Test
    @DisplayName("findAll should find all cards")
    void findAll_shouldFindAllCards() {
        val entity = PokemonCardFixtures.pikachu();
        val dto = PokemonCardDTOFixtures.pikachu();

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
