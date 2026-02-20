package it.finconsgroup.tcgcollection.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Abstract base DTO for all TCG cards.
 * Contains common fields shared across different card games.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseCardDTO {
    private String id;
    private String name;
    private String rarity;
    private String setName;
    private String setCode;
    private String cardNumber;
    private Integer quantity;
    private String condition;
    private String language;
}
