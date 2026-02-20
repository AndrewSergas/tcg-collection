package it.finconsgroup.tcgcollection.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO representing the count of cards grouped by rarity.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RarityCount {
    private String rarity;
    private Long count;
}
