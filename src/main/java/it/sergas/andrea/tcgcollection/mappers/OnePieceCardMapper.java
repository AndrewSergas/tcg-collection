package it.sergas.andrea.tcgcollection.mappers;

import it.sergas.andrea.tcgcollection.dtos.OnePieceCardDTO;
import it.sergas.andrea.tcgcollection.entities.OnePieceCard;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for converting between OnePieceCard entities and OnePieceCardDTO.
 */
@Mapper(componentModel = "spring")
public interface OnePieceCardMapper
        extends BaseMapper<OnePieceCard, OnePieceCardDTO> {

    /**
     * Converts a OnePieceCard entity to a OnePieceCardDTO.
     *
     * @param entity the OnePieceCard entity to convert
     * @return the corresponding OnePieceCardDTO
     */
    @Override
    @Mapping(source = "id", target = "id", qualifiedByName = "objectIdToString")
    OnePieceCardDTO toDTO(OnePieceCard entity);
}
