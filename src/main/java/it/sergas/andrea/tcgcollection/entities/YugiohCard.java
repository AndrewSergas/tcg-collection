package it.sergas.andrea.tcgcollection.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Entity representing a Yu-Gi-Oh! Trading Card.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Document(collection = "yugioh_cards")
public class YugiohCard
        extends BaseCard {
    private String cardType;
    private String monsterType;
    private String attribute;
    private Integer level;
    private Integer rank;
    private Integer linkRating;
    private Integer pendulumScale;
    private Integer attack;
    private Integer defense;
    private String description;
    private String archetype;
    private String race;
    private String frameType;
    private Boolean isBanned;
    private Boolean isLimited;
    private Boolean isSemiLimited;
}
