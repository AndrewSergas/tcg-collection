package it.finconsgroup.tcgcollection.mappers;

import it.finconsgroup.tcgcollection.dtos.MagicCardDTO;
import it.finconsgroup.tcgcollection.entities.MagicCard;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for converting between MagicCard entities and MagicCardDTO.
 */
@Mapper(componentModel = "spring")
public interface MagicCardMapper
        extends BaseMapper<MagicCard, MagicCardDTO> {

    /**
     * Converts a MagicCard entity to a MagicCardDTO.
     *
     * @param entity the MagicCard entity to convert
     * @return the corresponding MagicCardDTO
     */
    @Override
    @Mapping(source = "id", target = "id", qualifiedByName = "objectIdToString")
    MagicCardDTO toDTO(MagicCard entity);
}
