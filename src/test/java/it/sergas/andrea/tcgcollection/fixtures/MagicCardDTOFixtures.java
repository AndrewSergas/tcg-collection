package it.sergas.andrea.tcgcollection.fixtures;

import it.sergas.andrea.tcgcollection.dtos.MagicCardDTO;
import lombok.NoArgsConstructor;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class MagicCardDTOFixtures {

    public static MagicCardDTO lightningBolt() {
        return MagicCardDTO.builder()
                .id("000000000000000000000001")
                .name("Lightning Bolt")
                .rarity("Common")
                .setName("Alpha")
                .setCode("LEA")
                .cardNumber("161")
                .type("Instant")
                .colors(List.of("Red"))
                .manaCost("{R}")
                .text("Lightning Bolt deals 3 damage to any target.")
                .build();
    }

    public static MagicCardDTO blackLotus() {
        return MagicCardDTO.builder()
                .id("000000000000000000000002")
                .name("Black Lotus")
                .rarity("Rare")
                .setName("Alpha")
                .setCode("LEA")
                .cardNumber("232")
                .type("Artifact")
                .colors(List.of())
                .manaCost("{0}")
                .text("{T}, Sacrifice Black Lotus: Add three mana of any one color.")
                .build();
    }

    public static MagicCardDTO counterspell() {
        return MagicCardDTO.builder()
                .id("000000000000000000000003")
                .name("Counterspell")
                .rarity("Common")
                .setName("Alpha")
                .setCode("LEA")
                .cardNumber("054")
                .type("Instant")
                .colors(List.of("Blue"))
                .manaCost("{U}{U}")
                .text("Counter target spell.")
                .build();
    }

    public static MagicCardDTO serraAngel() {
        return MagicCardDTO.builder()
                .id("000000000000000000000004")
                .name("Serra Angel")
                .rarity("Uncommon")
                .setName("Alpha")
                .setCode("LEA")
                .cardNumber("038")
                .type("Creature - Angel")
                .colors(List.of("White"))
                .manaCost("{3}{W}{W}")
                .text("Flying, vigilance")
                .power("4")
                .toughness("4")
                .build();
    }

    public static MagicCardDTO giantGrowth() {
        return MagicCardDTO.builder()
                .id("000000000000000000000005")
                .name("Giant Growth")
                .rarity("Common")
                .setName("Alpha")
                .setCode("LEA")
                .cardNumber("195")
                .type("Instant")
                .colors(List.of("Green"))
                .manaCost("{G}")
                .text("Target creature gets +3/+3 until end of turn.")
                .build();
    }
}
