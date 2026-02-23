package it.sergas.andrea.tcgcollection.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO representing the average power of cards grouped by color.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ColorPowerAverage {
    private String color;
    private Double averagePower;
}
