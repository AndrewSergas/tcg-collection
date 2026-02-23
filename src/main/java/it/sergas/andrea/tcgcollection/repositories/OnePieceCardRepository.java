package it.sergas.andrea.tcgcollection.repositories;

import it.sergas.andrea.tcgcollection.entities.OnePieceCard;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for managing OnePieceCard entities.
 */
@Repository
public interface OnePieceCardRepository
        extends MongoRepository<OnePieceCard, ObjectId> {

    /**
     * Finds One Piece cards by color.
     *
     * @param color the color to search for
     * @return list of One Piece cards with the specified color
     */
    @Query("{}") // TODO: implement me
    List<OnePieceCard> findByColor(String color);

    /**
     * Finds One Piece cards with power greater than the specified value.
     *
     * @param power the minimum power value
     * @return list of One Piece cards with power greater than the specified value
     */
    @Query("{}") // TODO: implement me
    List<OnePieceCard> findByPowerGreaterThan(int power);
}
