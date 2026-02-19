# TCG Collection

Spring Boot application for managing TCG (Trading Card Game) collections.

## Prerequisites

- Java 25
- Maven 3.x
- Docker Desktop (for MongoDB)

## Starting MongoDB Database

To start the MongoDB database using Docker Compose:

```bash
docker-compose up -d
```

This command will:
- Download the MongoDB image (if not already present)
- Start a MongoDB container on port 27018
- Create a persistent volume for data
- Configure the `tcg-collection` database

To stop the database:

```bash
docker-compose down
```

To stop and remove data as well:

```bash
docker-compose down -v
```

## Starting the Application

1. Open the project in IntelliJ IDEA
2. Locate the main class `TcgCollectionApplication.java` in the project explorer
3. Right-click on the class and select "Run 'TcgCollectionApplication'"
4. Alternatively, open the class and click the green play button in the gutter next to the `main` method

The application will start and automatically populate the database with sample TCG cards from the JSON files in `src/main/resources/data/`.


## Configuration

Database configuration is located in `src/main/resources/application.yaml`:
- Host: localhost
- Port: 27018
- Database: tcg-collection

## Main Dependencies

- Spring Boot 4.0.2
- Spring Data MongoDB
- Lombok
- Spring Boot DevTools

## Card Collections

The application manages collections for the following TCG games:
- **Pokémon** (`pokemon_cards`)
- **Yu-Gi-Oh!** (`yugioh_cards`)
- **Magic: The Gathering** (`magic_cards`)
- **One Piece Card Game** (`onepiece_cards`)
- **Disney Lorcana** (`lorcana_cards`)

Sample data is loaded from JSON files in `src/main/resources/data/` on application startup.


