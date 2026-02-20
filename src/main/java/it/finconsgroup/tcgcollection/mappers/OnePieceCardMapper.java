package it.finconsgroup.tcgcollection.mappers;

import it.finconsgroup.tcgcollection.dtos.OnePieceCardDTO;
import it.finconsgroup.tcgcollection.entities.OnePieceCard;
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
