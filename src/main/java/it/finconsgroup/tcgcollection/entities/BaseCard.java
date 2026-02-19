package it.finconsgroup.tcgcollection.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * Abstract base class for all TCG cards.
 * Contains common fields shared across different card games.
 */
@Getter
@Setter
@ToString
@SuperBuilder
@EqualsAndHashCode
@NoArgsConstructor
public abstract class BaseCard {
    @Id private ObjectId id;
    private String name;
    private String rarity;
    private String setName;
    private String setCode;
    private String cardNumber;
    private Integer quantity;
    private String condition;
    private String language;
}
