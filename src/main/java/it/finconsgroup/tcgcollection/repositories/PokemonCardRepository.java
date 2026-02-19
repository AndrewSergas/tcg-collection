package it.finconsgroup.tcgcollection.repositories;

import it.finconsgroup.tcgcollection.entities.PokemonCard;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Pokémon cards.
 */
@Repository
public interface PokemonCardRepository
        extends MongoRepository<PokemonCard, ObjectId> {}
