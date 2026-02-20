# TCG Collection - MongoDB Exercises

A Spring Boot application for learning MongoDB queries through a Trading Card Game collection.

## Setup

### Start MongoDB
```bash
docker-compose up -d
```

This starts MongoDB on port 27018 with the database `tcg-collection`.

### Run the Application

Open the project in IntelliJ and run `TcgCollectionApplication`. The app starts on port 8080 and loads sample data automatically.

## Exercises

The project contains 15 MongoDB query exercises across different TCG games:
- Pokémon (3)
- Yu-Gi-Oh! (3)
- Magic: The Gathering (3)
- One Piece (2)
- Lorcana (2)
- Aggregations (2)

See `EXERCISES.md` for details.

## API Endpoints

Test your queries using these endpoints:

- `/api/pokemon` - Pokémon cards
- `/api/yugioh` - Yu-Gi-Oh! cards
- `/api/magic` - Magic cards
- `/api/onepiece` - One Piece cards
- `/api/lorcana` - Lorcana cards
- `/api/aggregations` - Advanced aggregation queries

Each has subpaths for specific queries (see controllers or EXERCISES.md).

## Project Structure

- **repositories/** - Implement your MongoDB queries here
- **services/** - Business logic (already implemented)
- **controllers/** - REST endpoints (already implemented)
- **entities/** - Card data models
- **resources/data/** - Sample JSON data files



