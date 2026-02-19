package it.finconsgroup.tcgcollection.repositories;

import it.finconsgroup.tcgcollection.entities.MagicCard;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Magic: The Gathering cards.
 */
@Repository
public interface MagicCardRepository
        extends MongoRepository<MagicCard, ObjectId> {}
