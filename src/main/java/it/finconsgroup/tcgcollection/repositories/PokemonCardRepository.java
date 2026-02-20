package it.finconsgroup.tcgcollection.repositories;

import it.finconsgroup.tcgcollection.entities.PokemonCard;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for managing PokemonCard entities.
 */
@Repository
public interface PokemonCardRepository
        extends MongoRepository<PokemonCard, ObjectId> {

    /**
     * Finds Pokémon cards by rarity.
     *
     * @param rarity the rarity to search for
     * @return list of Pokémon cards with the specified rarity
     */
    @Query("{}")
    List<PokemonCard> findByRarity(String rarity);

    /**
     * Finds Pokémon cards by type.
     *
     * @param type the type to search for
     * @return list of Pokémon cards with the specified type
     */
    @Query("{}")
    List<PokemonCard> findByType(String type);

    /**
     * Finds Pokémon cards that have attacks.
     *
     * @return list of Pokémon cards with attacks
     */
    @Query("{}")
    List<PokemonCard> findCardsWithAttacks();
}
