package it.sergas.andrea.tcgcollection.repositories;

import it.sergas.andrea.tcgcollection.dtos.PokemonTypeStats;
import it.sergas.andrea.tcgcollection.dtos.TypeCount;
import it.sergas.andrea.tcgcollection.entities.YugiohCard;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.data.mongodb.core.aggregation.ConvertOperators;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for performing aggregation operations across card collections.
 */
@Repository
@RequiredArgsConstructor
public class AggregationRepository {

    private final MongoTemplate mongoTemplate;

    /**
     * Counts Yu-Gi-Oh! cards grouped by card type (Monster, Spell, Trap).
     *
     * @return list of card type counts
     */
    public List<TypeCount> countYugiohCardsByType() {
        val pipeline = Aggregation.newAggregation(
                Aggregation.group("cardType").count().as("count"),
                Aggregation.addFields().addField("type").withValue("$_id").build(),
                Aggregation.project("type", "count").andExclude("_id"),
                Aggregation.sort(Sort.Direction.DESC, "count")
        );

        return mongoTemplate
                .aggregate(pipeline, YugiohCard.class, TypeCount.class)
                .getMappedResults();
    }

    /**
     * Calculates statistics for Pokémon cards grouped by type.
     * This aggregation performs the following steps:
     * <ol>
     *     <li>Filters cards that have a valid HP value</li>
     *     <li>Converts HP from string to integer</li>
     *     <li>Groups by pokemonType and calculates count, average HP, and max attack count</li>
     *     <li>Sorts results by card count in descending order</li>
     * </ol>
     *
     * @return list of Pokémon statistics per type
     */
    public List<PokemonTypeStats> getPokemonStatsByType() {
        // Step 1: Match cards where hp exists and is not null
        val matchValidHp = Aggregation.match(Criteria.where("hp").exists(true).ne(null));

        // Step 2: Add fields to convert HP and count attacks
        val addCalculatedFields = Aggregation.addFields()
                .addField("hpNumeric").withValueOf(ConvertOperators.ToInt.toInt("$hp"))
                .addField("attackCount").withValueOf(ArrayOperators.Size.lengthOfArray("$attacks"))
                .build();

        // Step 3: Group by pokemonType and calculate statistics
        val groupByType = Aggregation.group("pokemonType")
                .count().as("cardCount")
                .avg("hpNumeric").as("averageHp")
                .max("attackCount").as("maxAttacks");

        // Step 4: Sort by card count descending
        val sortByCount = Aggregation.sort(Sort.Direction.DESC, "cardCount");

        // Step 5: Project to match DTO structure
        val projectToDTO = Aggregation.project()
                .and("_id").as("pokemonType")
                .and("cardCount").as("cardCount")
                .and("averageHp").as("averageHp")
                .and("maxAttacks").as("maxAttacks");

        val aggregation = Aggregation.newAggregation(
                matchValidHp,
                addCalculatedFields,
                groupByType,
                sortByCount,
                projectToDTO
        );

        return mongoTemplate
                .aggregate(aggregation, "pokemon_cards", PokemonTypeStats.class)
                .getMappedResults();
    }
}
