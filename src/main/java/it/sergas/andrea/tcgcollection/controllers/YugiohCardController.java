package it.sergas.andrea.tcgcollection.controllers;

import it.sergas.andrea.tcgcollection.dtos.YugiohCardDTO;
import it.sergas.andrea.tcgcollection.services.YugiohCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for Yu-Gi-Oh! card operations.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/yugioh")
public class YugiohCardController {

    private final YugiohCardService service;

    /**
     * Retrieves all Yu-Gi-Oh! cards.
     *
     * @return list of all Yu-Gi-Oh! card DTOs
     */
    @GetMapping
    public List<YugiohCardDTO> getAllCards() {
        return service.findAll();
    }

    /**
     * Finds Yu-Gi-Oh! cards by card type.
     *
     * @param cardType the card type to search for
     * @return list of Yu-Gi-Oh! card DTOs with the specified card type
     */
    @GetMapping("/card-type/{cardType}")
    public List<YugiohCardDTO> findByCardType(@PathVariable final String cardType) {
        return service.findByCardType(cardType);
    }

    /**
     * Finds Yu-Gi-Oh! cards with attack greater than the specified value.
     *
     * @param attack the minimum attack value
     * @return list of Yu-Gi-Oh! card DTOs with attack greater than the specified value
     */
    @GetMapping("/attack-greater-than/{attack}")
    public List<YugiohCardDTO> findByAttackGreaterThan(@PathVariable final int attack) {
        return service.findByAttackGreaterThan(attack);
    }

    /**
     * Finds Yu-Gi-Oh! cards where defense is greater than attack.
     *
     * @return list of Yu-Gi-Oh! card DTOs with defense greater than attack
     */
    @GetMapping("/defense-greater-than-attack")
    public List<YugiohCardDTO> findCardsWithDefenseGreaterThanAttack() {
        return service.findCardsWithDefenseGreaterThanAttack();
    }
}
