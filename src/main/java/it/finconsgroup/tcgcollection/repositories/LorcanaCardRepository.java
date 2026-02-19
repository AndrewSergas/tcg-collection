package it.finconsgroup.tcgcollection.repositories;

import it.finconsgroup.tcgcollection.entities.LorcanaCard;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Disney Lorcana cards.
 */
@Repository
public interface LorcanaCardRepository
        extends MongoRepository<LorcanaCard, ObjectId> {}
