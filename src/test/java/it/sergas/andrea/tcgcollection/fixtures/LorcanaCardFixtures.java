package it.sergas.andrea.tcgcollection.fixtures;

import it.sergas.andrea.tcgcollection.entities.LorcanaCard;
import lombok.NoArgsConstructor;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class LorcanaCardFixtures {

    public static LorcanaCard elsa() {
        return LorcanaCard.builder()
                .name("Elsa - Snow Queen")
                .rarity("Legendary")
                .setName("The First Chapter")
                .setCode("TFC")
                .cardNumber("001")
                .inkColors(List.of("Amber", "Sapphire"))
                .inkCost(8)
                .isInkable(true)
                .strength(4)
                .willpower(6)
                .lore(3)
                .franchiseTitle("Frozen")
                .cardType("Character")
                .abilities("Freeze - When this character is played, freeze all opposing characters.")
                .build();
    }

    public static LorcanaCard mickey() {
        return LorcanaCard.builder()
                .name("Mickey Mouse - Brave Little Tailor")
                .rarity("Super Rare")
                .setName("The First Chapter")
                .setCode("TFC")
                .cardNumber("050")
                .inkColors(List.of("Steel"))
                .inkCost(5)
                .isInkable(true)
                .strength(3)
                .willpower(4)
                .lore(2)
                .franchiseTitle("Mickey Mouse")
                .cardType("Character")
                .abilities("Bodyguard - This character may enter play exerted.")
                .build();
    }

    public static LorcanaCard simba() {
        return LorcanaCard.builder()
                .name("Simba - Rightful Heir")
                .rarity("Rare")
                .setName("Rise of the Floodborn")
                .setCode("ROF")
                .cardNumber("115")
                .inkColors(List.of("Amber"))
                .inkCost(6)
                .isInkable(true)
                .strength(5)
                .willpower(5)
                .lore(2)
                .franchiseTitle("The Lion King")
                .cardType("Character")
                .abilities("Challenge +2 - While challenging, this character gets +2 strength.")
                .build();
    }
}
