package it.sergas.andrea.tcgcollection.controllers;

import it.sergas.andrea.tcgcollection.dtos.MagicCardDTO;
import it.sergas.andrea.tcgcollection.services.MagicCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for Magic: The Gathering card operations.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/magic")
public class MagicCardController {

    private final MagicCardService service;

    /**
     * Retrieves all Magic: The Gathering cards.
     *
     * @return list of all Magic card DTOs
     */
    @GetMapping
    public List<MagicCardDTO> getAllCards() {
        return service.findAll();
    }

    /**
     * Finds Magic: The Gathering cards by type.
     *
     * @param type the card type to search for
     * @return list of Magic card DTOs with the specified type
     */
    @GetMapping("/type/{type}")
    public List<MagicCardDTO> findByType(@PathVariable final String type) {
        return service.findByType(type);
    }

    /**
     * Finds Magic: The Gathering cards by color.
     *
     * @param color the color to search for
     * @return list of Magic card DTOs with the specified color
     */
    @GetMapping("/color/{color}")
    public List<MagicCardDTO> findByColor(@PathVariable final String color) {
        return service.findByColor(color);
    }

    /**
     * Finds Magic: The Gathering cards containing the specified keyword in their text.
     *
     * @param keyword the keyword to search for in card text
     * @return list of Magic card DTOs containing the keyword
     */
    @GetMapping("/text-contains/{keyword}")
    public List<MagicCardDTO> findByTextContaining(@PathVariable final String keyword) {
        return service.findByTextContaining(keyword);
    }
}
