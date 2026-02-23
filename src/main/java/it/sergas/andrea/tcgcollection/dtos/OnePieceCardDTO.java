package it.sergas.andrea.tcgcollection.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * DTO representing a One Piece Card Game card.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OnePieceCardDTO
        extends BaseCardDTO {
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
