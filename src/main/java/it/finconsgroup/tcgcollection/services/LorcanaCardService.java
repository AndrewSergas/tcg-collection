package it.finconsgroup.tcgcollection.services;

import it.finconsgroup.tcgcollection.dtos.LorcanaCardDTO;
import it.finconsgroup.tcgcollection.mappers.LorcanaCardMapper;
import it.finconsgroup.tcgcollection.repositories.LorcanaCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for managing Disney Lorcana cards.
 */
@Service
@RequiredArgsConstructor
public class LorcanaCardService {

    private final LorcanaCardMapper mapper;
    private final LorcanaCardRepository repository;

    /**
     * Finds Lorcana cards by ink color.
     *
     * @param inkColor the ink color to search for
     * @return list of Lorcana card DTOs with the specified ink color
     */
    public List<LorcanaCardDTO> findByInkColor(final String inkColor) {
        return repository.findByInkColor(inkColor).stream().map(mapper::toDTO).toList();
    }

    /**
     * Finds Lorcana cards by franchise title.
     *
     * @param franchiseTitle the franchise title to search for
     * @return list of Lorcana card DTOs with the specified franchise title
     */
    public List<LorcanaCardDTO> findByFranchiseTitle(final String franchiseTitle) {
        return repository.findByFranchiseTitle(franchiseTitle).stream().map(mapper::toDTO).toList();
    }

    /**
     * Finds all Lorcana cards.
     *
     * @return list of all Lorcana card DTOs
     */
    public List<LorcanaCardDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }
}
