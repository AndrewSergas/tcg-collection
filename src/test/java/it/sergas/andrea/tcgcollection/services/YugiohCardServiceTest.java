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
    @InjectMocks private YugiohCardService service;

    @Test
    @DisplayName("Should find cards by card type")
    void shouldFindCardsByCardType() {
        val entity = YugiohCardFixtures.darkMagician();
        val dto = YugiohCardDTOFixtures.darkMagician();

        when(repository.findByCardType("Monster")).thenReturn(List.of(entity));
        when(mapper.toDTO(entity)).thenReturn(dto);

        assertThat(service.findByCardType("Monster")).containsExactly(dto);
    }

    @Test
    @DisplayName("Should return empty list when no cards found by card type")
    void shouldReturnEmptyListWhenNoCardsByCardType() {
        when(repository.findByCardType("Ritual")).thenReturn(List.of());
        assertThat(service.findByCardType("Ritual")).isEmpty();
    }

    @Test
    @DisplayName("Should find cards by attack greater than")
    void shouldFindCardsByAttackGreaterThan() {
        val entity = YugiohCardFixtures.blueEyesWhiteDragon();
        val dto = YugiohCardDTOFixtures.blueEyesWhiteDragon();

        when(repository.findByAttackGreaterThan(2000)).thenReturn(List.of(entity));
        when(mapper.toDTO(entity)).thenReturn(dto);

        assertThat(service.findByAttackGreaterThan(2000)).containsExactly(dto);
    }

    @Test
    @DisplayName("Should return empty list when no cards with attack greater than")
    void shouldReturnEmptyListWhenNoCardsByAttackGreaterThan() {
        when(repository.findByAttackGreaterThan(9999)).thenReturn(List.of());
        assertThat(service.findByAttackGreaterThan(9999)).isEmpty();
    }

    @Test
    @DisplayName("Should find cards with defense greater than attack")
    void shouldFindCardsWithDefenseGreaterThanAttack() {
        val entity = YugiohCardFixtures.wallOfIllusion();
        val dto = YugiohCardDTOFixtures.wallOfIllusion();

        when(repository.findCardsWithDefenseGreaterThanAttack()).thenReturn(List.of(entity));
        when(mapper.toDTO(entity)).thenReturn(dto);

        assertThat(service.findCardsWithDefenseGreaterThanAttack()).containsExactly(dto);
    }

    @Test
    @DisplayName("Should return empty list when no cards with defense greater than attack")
    void shouldReturnEmptyListWhenNoCardsWithDefenseGreaterThanAttack() {
        when(repository.findCardsWithDefenseGreaterThanAttack()).thenReturn(List.of());
        assertThat(service.findCardsWithDefenseGreaterThanAttack()).isEmpty();
    }

    @Test
    @DisplayName("Should find all cards")
    void shouldFindAllCards() {
        val entity = YugiohCardFixtures.darkMagician();
        val dto = YugiohCardDTOFixtures.darkMagician();

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
