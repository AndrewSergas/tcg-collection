package it.sergas.andrea.tcgcollection.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * DTO representing a Yu-Gi-Oh! Trading Card.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class YugiohCardDTO
        extends BaseCardDTO {
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
