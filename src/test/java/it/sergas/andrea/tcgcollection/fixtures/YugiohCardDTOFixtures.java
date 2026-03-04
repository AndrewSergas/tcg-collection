package it.sergas.andrea.tcgcollection.fixtures;

import it.sergas.andrea.tcgcollection.dtos.YugiohCardDTO;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class YugiohCardDTOFixtures {

    public static YugiohCardDTO darkMagician() {
        return YugiohCardDTO.builder()
                .id("000000000000000000000001")
                .name("Dark Magician")
                .rarity("Ultra Rare")
                .setName("Legend of Blue Eyes White Dragon")
                .setCode("LOB")
                .cardNumber("005")
                .cardType("Monster")
                .attribute("Dark")
                .monsterType("Spellcaster")
                .level(7)
                .attack(2500)
                .defense(2100)
                .description("The ultimate wizard in terms of attack and defense.")
                .build();
    }

    public static YugiohCardDTO blueEyesWhiteDragon() {
        return YugiohCardDTO.builder()
                .id("000000000000000000000002")
                .name("Blue-Eyes White Dragon")
                .rarity("Ultra Rare")
                .setName("Legend of Blue Eyes White Dragon")
                .setCode("LOB")
                .cardNumber("001")
                .cardType("Monster")
                .attribute("Light")
                .monsterType("Dragon")
                .level(8)
                .attack(3000)
                .defense(2500)
                .description("This legendary dragon is a powerful engine of destruction.")
                .build();
    }

    public static YugiohCardDTO kuriboh() {
        return YugiohCardDTO.builder()
                .id("000000000000000000000003")
                .name("Kuriboh")
                .rarity("Common")
                .setName("Legend of Blue Eyes White Dragon")
                .setCode("LOB")
                .cardNumber("046")
                .cardType("Monster")
                .attribute("Dark")
                .monsterType("Fiend")
                .level(1)
                .attack(300)
                .defense(200)
                .description("A very weak monster that can be used as a shield.")
                .build();
    }

    public static YugiohCardDTO wallOfIllusion() {
        return YugiohCardDTO.builder()
                .id("000000000000000000000004")
                .name("Wall of Illusion")
                .rarity("Rare")
                .setName("Metal Raiders")
                .setCode("MRD")
                .cardNumber("055")
                .cardType("Monster")
                .attribute("Dark")
                .monsterType("Fiend")
                .level(4)
                .attack(1000)
                .defense(1850)
                .description("Any monster that attacks this monster is returned to its owner's hand.")
                .build();
    }

    public static YugiohCardDTO mirrorForce() {
        return YugiohCardDTO.builder()
                .id("000000000000000000000005")
                .name("Mirror Force")
                .rarity("Ultra Rare")
                .setName("Metal Raiders")
                .setCode("MRD")
                .cardNumber("138")
                .cardType("Trap")
                .description("When an opponent's monster declares an attack: Destroy all your opponent's Attack Position monsters.")
                .build();
    }

    public static YugiohCardDTO potOfGreed() {
        return YugiohCardDTO.builder()
                .id("000000000000000000000006")
                .name("Pot of Greed")
                .rarity("Rare")
                .setName("Legend of Blue Eyes White Dragon")
                .setCode("LOB")
                .cardNumber("119")
                .cardType("Spell")
                .description("Draw 2 cards from your Deck.")
                .build();
    }
}
