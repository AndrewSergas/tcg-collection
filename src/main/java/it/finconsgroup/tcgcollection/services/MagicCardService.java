package it.finconsgroup.tcgcollection.services;

import it.finconsgroup.tcgcollection.dtos.MagicCardDTO;
import it.finconsgroup.tcgcollection.mappers.MagicCardMapper;
import it.finconsgroup.tcgcollection.repositories.MagicCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for managing Magic: The Gathering cards.
 */
@Service
@RequiredArgsConstructor
public class MagicCardService {

    private final MagicCardMapper mapper;
    private final MagicCardRepository repository;

    /**
     * Finds Magic: The Gathering cards by type.
     *
     * @param type the card type to search for
     * @return list of Magic card DTOs with the specified type
     */
    public List<MagicCardDTO> findByType(final String type) {
        return repository.findByType(type).stream().map(mapper::toDTO).toList();
    }

    /**
     * Finds Magic: The Gathering cards by color.
     *
     * @param color the color to search for
     * @return list of Magic card DTOs with the specified color
     */
    public List<MagicCardDTO> findByColor(final String color) {
        return repository.findByColor(color).stream().map(mapper::toDTO).toList();
    }

    /**
     * Finds Magic: The Gathering cards containing the specified keyword in their text.
     *
     * @param keyword the keyword to search for in card text
     * @return list of Magic card DTOs containing the keyword
     */
    public List<MagicCardDTO> findByTextContaining(final String keyword) {
        return repository.findByTextContaining(keyword).stream().map(mapper::toDTO).toList();
    }

    /**
     * Finds all Magic: The Gathering cards.
     *
     * @return list of all Magic card DTOs
     */
    public List<MagicCardDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }
}
