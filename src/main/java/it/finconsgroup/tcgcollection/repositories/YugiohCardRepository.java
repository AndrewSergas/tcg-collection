package it.finconsgroup.tcgcollection.repositories;

import it.finconsgroup.tcgcollection.entities.YugiohCard;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Yu-Gi-Oh! cards.
 */
@Repository
public interface YugiohCardRepository
        extends MongoRepository<YugiohCard, ObjectId> {}
