package it.sergas.andrea.tcgcollection.controllers;

import it.sergas.andrea.tcgcollection.dtos.LorcanaCardDTO;
import it.sergas.andrea.tcgcollection.services.LorcanaCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for Disney Lorcana card operations.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lorcana")
public class LorcanaCardController {

    private final LorcanaCardService service;

    /**
     * Retrieves all Lorcana cards.
     *
     * @return list of all Lorcana card DTOs
     */
    @GetMapping
    public List<LorcanaCardDTO> getAllCards() {
        return service.findAll();
    }

    /**
     * Finds Lorcana cards by ink color.
     *
     * @param inkColor the ink color to search for
     * @return list of Lorcana card DTOs with the specified ink color
     */
    @GetMapping("/ink-color/{inkColor}")
    public List<LorcanaCardDTO> findByInkColor(@PathVariable final String inkColor) {
        return service.findByInkColor(inkColor);
    }

    /**
     * Finds Lorcana cards by franchise title.
     *
     * @param franchiseTitle the franchise title to search for
     * @return list of Lorcana card DTOs with the specified franchise title
     */
    @GetMapping("/franchise/{franchiseTitle}")
    public List<LorcanaCardDTO> findByFranchiseTitle(@PathVariable final String franchiseTitle) {
        return service.findByFranchiseTitle(franchiseTitle);
    }
}
