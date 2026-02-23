package it.sergas.andrea.tcgcollection.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO representing a generic count grouped by type/category.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TypeCount {
    private String type;
    private Long count;
}
