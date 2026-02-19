package it.finconsgroup.tcgcollection.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Entity representing a Pokémon Trading Card.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Document(collection = "pokemon_cards")
public class PokemonCard
        extends BaseCard {
    private String pokemonType;
    private List<String> types;
    private String hp;
    private String evolvedFrom;
    private List<Attack> attacks;
    private List<Ability> abilities;
    private List<Weakness> weaknesses;
    private List<Resistance> resistances;
    private String retreatCost;

    @Data
    public static class Attack {
        private String name;
        private List<String> cost;
        private String damage;
        private String text;
    }

    @Data
    public static class Ability {
        private String name;
        private String text;
        private String type;
    }

    @Data
    public static class Weakness {
        private String type;
        private String value;
    }

    @Data
    public static class Resistance {
        private String type;
        private String value;
    }
}
