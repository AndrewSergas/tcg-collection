package it.sergas.andrea.tcgcollection.fixtures;

import it.sergas.andrea.tcgcollection.entities.MagicCard;
import lombok.NoArgsConstructor;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class MagicCardFixtures {

    public static MagicCard lightningBolt() {
        return MagicCard.builder()
                .name("Lightning Bolt")
                .rarity("Common")
                .setName("Alpha")
                .setCode("LEA")
                .cardNumber("161")
                .type("Instant")
                .colors(List.of("Red"))
                .manaCost("{R}")
                .text("Lightning Bolt deals 3 damage to any target.")
                .power(null)
                .toughness(null)
                .build();
    }

    public static MagicCard blackLotus() {
        return MagicCard.builder()
                .name("Black Lotus")
                .rarity("Rare")
                .setName("Alpha")
                .setCode("LEA")
                .cardNumber("232")
                .type("Artifact")
                .colors(List.of())
                .manaCost("{0}")
                .text("{T}, Sacrifice Black Lotus: Add three mana of any one color.")
                .power(null)
                .toughness(null)
                .build();
    }

    public static MagicCard counterspell() {
        return MagicCard.builder()
                .name("Counterspell")
                .rarity("Common")
                .setName("Alpha")
                .setCode("LEA")
                .cardNumber("054")
                .type("Instant")
                .colors(List.of("Blue"))
                .manaCost("{U}{U}")
                .text("Counter target spell.")
                .power(null)
                .toughness(null)
                .build();
    }

    public static MagicCard serraAngel() {
        return MagicCard.builder()
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

    public static MagicCard giantGrowth() {
        return MagicCard.builder()
                .name("Giant Growth")
                .rarity("Common")
                .setName("Alpha")
                .setCode("LEA")
                .cardNumber("195")
                .type("Instant")
                .colors(List.of("Green"))
                .manaCost("{G}")
                .text("Target creature gets +3/+3 until end of turn.")
                .power(null)
                .toughness(null)
                .build();
    }
}
