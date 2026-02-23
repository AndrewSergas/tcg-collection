package it.sergas.andrea.tcgcollection.services;

import it.sergas.andrea.tcgcollection.dtos.OnePieceCardDTO;
import it.sergas.andrea.tcgcollection.mappers.OnePieceCardMapper;
import it.sergas.andrea.tcgcollection.repositories.OnePieceCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for managing One Piece Card Game cards.
 */
@Service
@RequiredArgsConstructor
public class OnePieceCardService {

    private final OnePieceCardMapper mapper;
    private final OnePieceCardRepository repository;

    /**
     * Finds One Piece cards by color.
     *
     * @param color the color to search for
     * @return list of One Piece card DTOs with the specified color
     */
    public List<OnePieceCardDTO> findByColor(final String color) {
        return repository.findByColor(color).stream().map(mapper::toDTO).toList();
    }

    /**
     * Finds One Piece cards with power greater than the specified value.
     *
     * @param power the minimum power value
     * @return list of One Piece card DTOs with power greater than the specified value
     */
    public List<OnePieceCardDTO> findByPowerGreaterThan(final int power) {
        return repository.findByPowerGreaterThan(power).stream().map(mapper::toDTO).toList();
    }

    /**
     * Finds all One Piece cards.
     *
     * @return list of all One Piece card DTOs
     */
    public List<OnePieceCardDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }
}
