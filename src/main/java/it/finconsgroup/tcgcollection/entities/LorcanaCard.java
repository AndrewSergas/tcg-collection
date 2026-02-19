package it.finconsgroup.tcgcollection.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Entity representing a Disney Lorcana card.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Document(collection = "lorcana_cards")
public class LorcanaCard
        extends BaseCard {
    private String cardType;
    private List<String> inkColors;
    private Integer inkCost;
    private Boolean isInkable;
    private Integer strength;
    private Integer willpower;
    private Integer lore;
    private String version;
    private List<String> classifications;
    private String abilities;
    private String flavorText;
    private String franchiseTitle;
}
