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
 * Entity representing a One Piece Card Game card.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Document(collection = "onepiece_cards")
public class OnePieceCard
        extends BaseCard {
    private String cardType;
    private List<String> colors;
    private Integer cost;
    private Integer power;
    private Integer counter;
    private String attribute;
    private List<String> types;
    private String effect;
    private String trigger;
    private String category;
    private String life;
}
