package it.finconsgroup.tcgcollection.mappers;

import it.finconsgroup.tcgcollection.dtos.LorcanaCardDTO;
import it.finconsgroup.tcgcollection.entities.LorcanaCard;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

/**
 * Mapper for converting between LorcanaCard entities and LorcanaCardDTO.
 */
@Mapper(componentModel = SPRING)
public interface LorcanaCardMapper
        extends BaseMapper<LorcanaCard, LorcanaCardDTO> {

    /**
     * Converts a LorcanaCard entity to a LorcanaCardDTO.
     *
     * @param entity the LorcanaCard entity to convert
     * @return the corresponding LorcanaCardDTO
     */
    @Override
    @Mapping(source = "id", target = "id", qualifiedByName = "objectIdToString")
    LorcanaCardDTO toDTO(LorcanaCard entity);
}
