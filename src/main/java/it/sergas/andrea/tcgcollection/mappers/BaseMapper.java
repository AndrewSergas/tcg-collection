package it.sergas.andrea.tcgcollection.mappers;

import it.sergas.andrea.tcgcollection.dtos.BaseCardDTO;
import it.sergas.andrea.tcgcollection.entities.BaseCard;
import org.bson.types.ObjectId;
import org.mapstruct.Named;

/**
 * Base mapper interface for mapping between BaseCard entities and BaseCardDTO.
 */
public interface BaseMapper<E extends BaseCard, D extends BaseCardDTO> {

    /**
     * Maps an entity to a DTO.
     *
     * @param entity the entity to map
     * @return the corresponding DTO
     */
    D toDTO(E entity);

    /**
     * Maps an ObjectId to a String.
     *
     * @param objectId the ObjectId to map
     * @return the string representation of the ObjectId
     */
    @Named("objectIdToString")
    default String mapObjectIdToString(final ObjectId objectId) {
        return objectId != null ? objectId.toHexString() : null;
    }
}
