package it.sergas.andrea.tcgcollection.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Entity representing a Magic: The Gathering card.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Document(collection = "magic_cards")
public class MagicCard
        extends BaseCard {
    private String manaCost;
    private Double convertedManaCost;
    private List<String> colors;
    private List<String> colorIdentity;
    private String type;
    private List<String> supertypes;
    private List<String> types;
    private List<String> subtypes;
    private String text;
    private String flavorText;
    private String power;
    private String toughness;
    private String loyalty;
    private String layout;
    private Boolean isFoil;
    private Boolean isReservedList;
    private String borderColor;
    private String frameVersion;
}
