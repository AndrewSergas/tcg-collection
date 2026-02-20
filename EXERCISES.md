# MongoDB Exercises

## Pokémon

### 1. Find by Rarity
`PokemonCardRepository.findByRarity(String rarity)`

Find all cards with a specific rarity.

**Test:** `GET /api/pokemon/rarity/Common`

<details>
<summary>Solution</summary>

```java
@Query("{'rarity': ?0}")
```
</details>

### 2. Find by Type
`PokemonCardRepository.findByType(String type)`

Find cards containing a specific type in their array.

**Test:** `GET /api/pokemon/type/Lightning`

<details>
<summary>Solution</summary>

```java
@Query("{'types': ?0}")
```
</details>

### 3. Find Cards with Attacks
`PokemonCardRepository.findCardsWithAttacks()`

Find cards where the attacks array exists and is not empty.

**Test:** `GET /api/pokemon/with-attacks`

<details>
<summary>Solution</summary>

```java
@Query("{'attacks': {$exists: true, $ne: []}}")
```
</details>

---

## Yu-Gi-Oh!

### 4. Find by Card Type
`YugiohCardRepository.findByCardType(String cardType)`

Find cards by type (Monster, Spell, Trap).

**Test:** `GET /api/yugioh/card-type/Monster`

<details>
<summary>Solution</summary>

```java
@Query("{'cardType': ?0}")
```
</details>

### 5. Find by Attack Greater Than
`YugiohCardRepository.findByAttackGreaterThan(int attack)`

Find cards with attack points greater than a value.

**Test:** `GET /api/yugioh/attack-greater-than/2000`

<details>
<summary>Solution</summary>

```java
@Query("{'attack': {$gt: ?0}}")
```
</details>

### 6. Defense Greater Than Attack
`YugiohCardRepository.findCardsWithDefenseGreaterThanAttack()`

Find cards where defense > attack. Use `$expr` to compare two fields.

**Test:** `GET /api/yugioh/defense-greater-than-attack`

<details>
<summary>Solution</summary>

```java
@Query("{$expr: {$gt: ['$defense', '$attack']}}")
```
</details>

---

## Magic: The Gathering

### 7. Find by Type
`MagicCardRepository.findByType(String type)`

**Test:** `GET /api/magic/type/Artifact`

<details>
<summary>Solution</summary>

```java
@Query("{'type': ?0}")
```
</details>

### 8. Find by Color
`MagicCardRepository.findByColor(String color)`

Find cards containing a specific color.

**Test:** `GET /api/magic/color/Red`

<details>
<summary>Solution</summary>

```java
@Query("{'colors': ?0}")
```
</details>

### 9. Find by Text Contains
`MagicCardRepository.findByTextContaining(String keyword)`

Case-insensitive text search using regex.

**Test:** `GET /api/magic/text-contains/damage`

<details>
<summary>Solution</summary>

```java
@Query("{'text': {$regex: ?0, $options: 'i'}}")
```
</details>

---

## One Piece

### 10. Find by Color
`OnePieceCardRepository.findByColor(String color)`

**Test:** `GET /api/onepiece/color/Red`

<details>
<summary>Solution</summary>

```java
@Query("{'colors': ?0}")
```
</details>

### 11. Find by Power Greater Than
`OnePieceCardRepository.findByPowerGreaterThan(int power)`

**Test:** `GET /api/onepiece/power-greater-than/4000`

<details>
<summary>Solution</summary>

```java
@Query("{'power': {$gt: ?0}}")
```
</details>

---

## Lorcana

### 12. Find by Ink Color
`LorcanaCardRepository.findByInkColor(String inkColor)`

**Test:** `GET /api/lorcana/ink-color/Steel`

<details>
<summary>Solution</summary>

```java
@Query("{'inkColors': ?0}")
```
</details>

### 13. Find by Franchise
`LorcanaCardRepository.findByFranchiseTitle(String franchiseTitle)`

**Test:** `GET /api/lorcana/franchise/Frozen`

<details>
<summary>Solution</summary>

```java
@Query("{'franchiseTitle': ?0}")
```
</details>

---

## Aggregations

### 14. Count Cards by Rarity Across All Collections
`AggregationRepository.countCardsByRarityAcrossAllCollections()`

Use `$unionWith` to combine all collections, then group by rarity.

**Test:** `GET /api/aggregations/cards-by-rarity`

<details>
<summary>Solution</summary>

```java
public List<RarityCount> countCardsByRarityAcrossAllCollections() {
    val aggregation = Aggregation.newAggregation(
        Aggregation.unionWith("yugioh_cards"),
        Aggregation.unionWith("magic_cards"),
        Aggregation.unionWith("onepiece_cards"),
        Aggregation.unionWith("lorcana_cards"),
        Aggregation.group("rarity").count().as("count"),
        Aggregation.project().and("_id").as("rarity").and("count").as("count")
    );
    
    return mongoTemplate
            .aggregate(aggregation, "pokemon_cards", RarityCount.class)
            .getMappedResults();
}
```
</details>

### 15. Pokémon Statistics by Type
`AggregationRepository.getPokemonStatsByType()`

Complex aggregation pipeline with multiple steps:
1. Filter cards with valid HP values
2. Convert HP from string to integer and count attacks
3. Group by pokemonType and calculate statistics (count, average HP, max attacks)
4. Sort by card count descending

**Test:** `GET /api/aggregations/pokemon-stats-by-type`

<details>
<summary>Solution</summary>

```java
public List<PokemonTypeStats> getPokemonStatsByType() {
    // Step 1: Match cards where hp exists and is not null
    val matchValidHp = Aggregation.match(Criteria.where("hp").exists(true).ne(null));
    
    // Step 2: Add fields to convert HP and count attacks
    val addCalculatedFields = Aggregation.addFields()
            .addField("hpNumeric").withValueOf(ConvertOperators.ToInt.toInt("$hp"))
            .addField("attackCount").withValueOf(ArrayOperators.Size.lengthOfArray("$attacks"))
            .build();
    
    // Step 3: Group by pokemonType and calculate statistics
    val groupByType = Aggregation.group("pokemonType")
            .count().as("cardCount")
            .avg("hpNumeric").as("averageHp")
            .max("attackCount").as("maxAttacks");
    
    // Step 4: Sort by card count descending
    val sortByCount = Aggregation.sort(Sort.Direction.DESC, "cardCount");
    
    // Step 5: Project to match DTO structure
    val projectToDTO = Aggregation.project()
            .and("_id").as("pokemonType")
            .and("cardCount").as("cardCount")
            .and("averageHp").as("averageHp")
            .and("maxAttacks").as("maxAttacks");
    
    val aggregation = Aggregation.newAggregation(
            matchValidHp,
            addCalculatedFields,
            groupByType,
            sortByCount,
            projectToDTO
    );
    
    return mongoTemplate
            .aggregate(aggregation, "pokemon_cards", PokemonTypeStats.class)
            .getMappedResults();
}
```
</details>

---

## Common Operators

**Comparison**
- `{field: value}` - exact match
- `{field: {$gt: value}}` - greater than
- `{field: {$lt: value}}` - less than
- `{field: {$gte: value}}` - greater than or equal
- `{field: {$lte: value}}` - less than or equal

**Logical**
- `{$and: [{}, {}]}` - AND
- `{$or: [{}, {}]}` - OR

**Element**
- `{field: {$exists: true}}` - field exists
- `{field: {$ne: value}}` - not equal

**Evaluation**
- `{field: {$regex: pattern, $options: 'i'}}` - regex match
- `{$expr: {$gt: ['$field1', '$field2']}}` - compare fields

**Array**
- `{arrayField: value}` - array contains value

**Tips**
- Use `?0`, `?1` for method parameters
- In `$expr`, prefix field names with `$`
- MongoDB automatically matches array elements

