package it.finconsgroup.tcgcollection.services;

import it.finconsgroup.tcgcollection.dtos.YugiohCardDTO;
import it.finconsgroup.tcgcollection.mappers.YugiohCardMapper;
import it.finconsgroup.tcgcollection.repositories.YugiohCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for managing Yu-Gi-Oh! cards.
 */
@Service
@RequiredArgsConstructor
public class YugiohCardService {

    private final YugiohCardMapper mapper;
    private final YugiohCardRepository repository;

    /**
     * Finds Yu-Gi-Oh! cards by card type.
     *
     * @param cardType the card type to search for
     * @return list of Yu-Gi-Oh! card DTOs with the specified card type
     */
    public List<YugiohCardDTO> findByCardType(final String cardType) {
        return repository.findByCardType(cardType).stream().map(mapper::toDTO).toList();
    }

    /**
     * Finds Yu-Gi-Oh! cards with attack greater than the specified value.
     *
     * @param attack the minimum attack value
     * @return list of Yu-Gi-Oh! card DTOs with attack greater than the specified value
     */
    public List<YugiohCardDTO> findByAttackGreaterThan(final int attack) {
        return repository.findByAttackGreaterThan(attack).stream().map(mapper::toDTO).toList();
    }

    /**
     * Finds Yu-Gi-Oh! cards where defense is greater than attack.
     *
     * @return list of Yu-Gi-Oh! card DTOs with defense greater than attack
     */
    public List<YugiohCardDTO> findCardsWithDefenseGreaterThanAttack() {
        return repository.findCardsWithDefenseGreaterThanAttack().stream().map(mapper::toDTO).toList();
    }

    /**
     * Finds all Yu-Gi-Oh! cards.
     *
     * @return list of all Yu-Gi-Oh! card DTOs
     */
    public List<YugiohCardDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }
}
