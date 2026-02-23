package it.sergas.andrea.tcgcollection.repositories;

import it.sergas.andrea.tcgcollection.entities.MagicCard;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for managing MagicCard entities.
 */
@Repository
public interface MagicCardRepository
        extends MongoRepository<MagicCard, ObjectId> {

    /**
     * Finds Magic: The Gathering cards by type.
     *
     * @param type the card type to search for
     * @return list of Magic cards with the specified type
     */
    @Query("{}") // TODO: implement me
    List<MagicCard> findByType(String type);

    /**
     * Finds Magic: The Gathering cards by color.
     *
     * @param color the color to search for
     * @return list of Magic cards with the specified color
     */
    @Query("{}") // TODO: implement me
    List<MagicCard> findByColor(String color);

    /**
     * Finds Magic: The Gathering cards containing the specified keyword in their text.
     *
     * @param keyword the keyword to search for in card text
     * @return list of Magic cards containing the keyword
     */
    @Query("{}") // TODO: implement me
    List<MagicCard> findByTextContaining(String keyword);
}
