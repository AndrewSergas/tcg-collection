package it.finconsgroup.tcgcollection.mappers;

import it.finconsgroup.tcgcollection.dtos.YugiohCardDTO;
import it.finconsgroup.tcgcollection.entities.YugiohCard;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for converting between YugiohCard entities and YugiohCardDTO.
 */
@Mapper(componentModel = "spring")
public interface YugiohCardMapper
        extends BaseMapper<YugiohCard, YugiohCardDTO> {

    /**
     * Converts a YugiohCard entity to a YugiohCardDTO.
     *
     * @param entity the YugiohCard entity to convert
     * @return the corresponding YugiohCardDTO
     */
    @Override
    @Mapping(source = "id", target = "id", qualifiedByName = "objectIdToString")
    YugiohCardDTO toDTO(YugiohCard entity);
}
