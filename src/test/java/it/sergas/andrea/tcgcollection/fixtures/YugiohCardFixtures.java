package it.sergas.andrea.tcgcollection.fixtures;

import it.sergas.andrea.tcgcollection.entities.YugiohCard;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class YugiohCardFixtures {

    public static YugiohCard darkMagician() {
        return YugiohCard.builder()
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

    public static YugiohCard blueEyesWhiteDragon() {
        return YugiohCard.builder()
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

    public static YugiohCard kuriboh() {
        return YugiohCard.builder()
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

    public static YugiohCard wallOfIllusion() {
        return YugiohCard.builder()
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

    public static YugiohCard shieldWall() {
        return YugiohCard.builder()
                .name("Shield Wall")
                .rarity("Common")
                .setName("Starter Deck")
                .setCode("SDK")
                .cardNumber("030")
                .cardType("Monster")
                .attribute("Earth")
                .monsterType("Warrior")
                .level(5)
                .attack(500)
                .defense(2000)
                .description("A defensive monster with high defense.")
                .build();
    }

    public static YugiohCard mirrorForce() {
        return YugiohCard.builder()
                .name("Mirror Force")
                .rarity("Ultra Rare")
                .setName("Metal Raiders")
                .setCode("MRD")
                .cardNumber("138")
                .cardType("Trap")
                .attribute(null)
                .monsterType(null)
                .level(null)
                .attack(null)
                .defense(null)
                .description("When an opponent's monster declares an attack: Destroy all your opponent's Attack Position monsters.")
                .build();
    }

    public static YugiohCard potOfGreed() {
        return YugiohCard.builder()
                .name("Pot of Greed")
                .rarity("Rare")
                .setName("Legend of Blue Eyes White Dragon")
                .setCode("LOB")
                .cardNumber("119")
                .cardType("Spell")
                .attribute(null)
                .monsterType(null)
                .level(null)
                .attack(null)
                .defense(null)
                .description("Draw 2 cards from your Deck.")
                .build();
    }
}
