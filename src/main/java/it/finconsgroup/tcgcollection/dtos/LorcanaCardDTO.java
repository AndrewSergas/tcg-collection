package it.finconsgroup.tcgcollection.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * DTO representing a Disney Lorcana card.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LorcanaCardDTO
        extends BaseCardDTO {
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
