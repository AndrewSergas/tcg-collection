package it.sergas.andrea.tcgcollection.mappers;

import it.sergas.andrea.tcgcollection.dtos.PokemonCardDTO;
import it.sergas.andrea.tcgcollection.entities.PokemonCard;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for converting between PokemonCard entities and PokemonCardDTO.
 */
@Mapper(componentModel = "spring")
public interface PokemonCardMapper
        extends BaseMapper<PokemonCard, PokemonCardDTO> {

    /**
     * Converts a PokemonCard entity to a PokemonCardDTO.
     *
     * @param entity the PokemonCard entity to convert
     * @return the corresponding PokemonCardDTO
     */
    @Override
    @Mapping(source = "id", target = "id", qualifiedByName = "objectIdToString")
    PokemonCardDTO toDTO(PokemonCard entity);
}
