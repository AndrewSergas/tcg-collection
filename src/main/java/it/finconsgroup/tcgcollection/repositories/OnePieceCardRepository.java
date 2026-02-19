package it.finconsgroup.tcgcollection.repositories;

import it.finconsgroup.tcgcollection.entities.OnePieceCard;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for One Piece Card Game cards.
 */
@Repository
public interface OnePieceCardRepository
        extends MongoRepository<OnePieceCard, ObjectId> {}
