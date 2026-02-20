package it.finconsgroup.tcgcollection.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * DTO representing a Magic: The Gathering card.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MagicCardDTO
        extends BaseCardDTO {
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
