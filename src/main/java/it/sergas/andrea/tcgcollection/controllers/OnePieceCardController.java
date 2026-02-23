package it.sergas.andrea.tcgcollection.controllers;

import it.sergas.andrea.tcgcollection.dtos.OnePieceCardDTO;
import it.sergas.andrea.tcgcollection.services.OnePieceCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for One Piece Card Game card operations.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/onepiece")
public class OnePieceCardController {

    private final OnePieceCardService service;

    /**
     * Retrieves all One Piece cards.
     *
     * @return list of all One Piece card DTOs
     */
    @GetMapping
    public List<OnePieceCardDTO> getAllCards() {
        return service.findAll();
    }

    /**
     * Finds One Piece cards by color.
     *
     * @param color the color to search for
     * @return list of One Piece card DTOs with the specified color
     */
    @GetMapping("/color/{color}")
    public List<OnePieceCardDTO> findByColor(@PathVariable final String color) {
        return service.findByColor(color);
    }

    /**
     * Finds One Piece cards with power greater than the specified value.
     *
     * @param power the minimum power value
     * @return list of One Piece card DTOs with power greater than the specified value
     */
    @GetMapping("/power-greater-than/{power}")
    public List<OnePieceCardDTO> findByPowerGreaterThan(@PathVariable final int power) {
        return service.findByPowerGreaterThan(power);
    }
}
