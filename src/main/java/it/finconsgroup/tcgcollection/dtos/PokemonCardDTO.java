package it.finconsgroup.tcgcollection.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * DTO representing a Pokémon Trading Card.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PokemonCardDTO
        extends BaseCardDTO {

    private String pokemonType;
    private List<String> types;
    private String hp;
    private String evolvedFrom;
    private List<AttackDTO> attacks;
    private List<AbilityDTO> abilities;
    private List<WeaknessDTO> weaknesses;
    private List<ResistanceDTO> resistances;
    private String retreatCost;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AttackDTO {
        private String name;
        private List<String> cost;
        private String damage;
        private String text;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AbilityDTO {
        private String name;
        private String text;
        private String type;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class WeaknessDTO {
        private String type;
        private String value;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResistanceDTO {
        private String type;
        private String value;
    }
}
