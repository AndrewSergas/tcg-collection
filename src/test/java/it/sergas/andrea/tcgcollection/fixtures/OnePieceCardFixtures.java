package it.sergas.andrea.tcgcollection.fixtures;

import it.sergas.andrea.tcgcollection.entities.OnePieceCard;
import lombok.NoArgsConstructor;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class OnePieceCardFixtures {

    public static OnePieceCard luffy() {
        return OnePieceCard.builder()
                .name("Monkey D. Luffy")
                .rarity("Leader")
                .setName("Starter Deck")
                .setCode("ST01")
                .cardNumber("001")
                .colors(List.of("Red"))
                .cost(0)
                .power(5000)
                .counter(0)
                .attribute("Slash")
                .cardType("Leader")
                .effect("DON!! +1. Your turn: Once per turn, you may add 1 card from the top of your Life area to your hand.")
                .build();
    }

    public static OnePieceCard zoro() {
        return OnePieceCard.builder()
                .name("Roronoa Zoro")
                .rarity("Super Rare")
                .setName("Starter Deck")
                .setCode("ST01")
                .cardNumber("013")
                .colors(List.of("Green"))
                .cost(4)
                .power(5000)
                .counter(1000)
                .attribute("Slash")
                .cardType("Character")
                .effect("On Play: K.O. up to 1 of your opponent's Characters with 3000 power or less.")
                .build();
    }

    public static OnePieceCard nami() {
        return OnePieceCard.builder()
                .name("Nami")
                .rarity("Common")
                .setName("Starter Deck")
                .setCode("ST01")
                .cardNumber("007")
                .colors(List.of("Blue"))
                .cost(2)
                .power(3000)
                .counter(1000)
                .attribute("Special")
                .cardType("Character")
                .effect("On Play: Draw 1 card if you have 5 or less cards in your hand.")
                .build();
    }

    public static OnePieceCard sanji() {
        return OnePieceCard.builder()
                .name("Sanji")
                .rarity("Uncommon")
                .setName("Starter Deck")
                .setCode("ST01")
                .cardNumber("009")
                .colors(List.of("Red"))
                .cost(3)
                .power(4000)
                .counter(2000)
                .attribute("Strike")
                .cardType("Character")
                .effect("Blocker. On Block: This Character gains +2000 power during this battle.")
                .build();
    }

    public static OnePieceCard robin() {
        return OnePieceCard.builder()
                .name("Nico Robin")
                .rarity("Rare")
                .setName("Starter Deck")
                .setCode("ST01")
                .cardNumber("008")
                .colors(List.of("Purple"))
                .cost(3)
                .power(4000)
                .counter(1000)
                .attribute("Wisdom")
                .cardType("Character")
                .effect("On Play: Look at 5 cards from the top of your deck and place them on the top or bottom of your deck in any order.")
                .build();
    }
}
