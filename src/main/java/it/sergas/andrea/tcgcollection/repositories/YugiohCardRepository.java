package it.sergas.andrea.tcgcollection.repositories;

import it.sergas.andrea.tcgcollection.entities.YugiohCard;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for managing YugiohCard entities.
 */
@Repository
public interface YugiohCardRepository
        extends MongoRepository<YugiohCard, ObjectId> {

    /**
     * Finds Yu-Gi-Oh! cards by card type.
     *
     * @param cardType the card type to search for
     * @return list of Yu-Gi-Oh! cards with the specified card type
     */
    @Query("{}") // TODO: implement me
    List<YugiohCard> findByCardType(String cardType);

    /**
     * Finds Yu-Gi-Oh! cards with attack greater than the specified value.
     *
     * @param attack the minimum attack value
     * @return list of Yu-Gi-Oh! cards with attack greater than the specified value
     */
    @Query("{}") // TODO: implement me
    List<YugiohCard> findByAttackGreaterThan(int attack);

    /**
     * Finds Yu-Gi-Oh! cards where defense is greater than attack.
     *
     * @return list of Yu-Gi-Oh! cards with defense greater than attack
     */
    @Query("{}") // TODO: implement me
    List<YugiohCard> findCardsWithDefenseGreaterThanAttack();
}
