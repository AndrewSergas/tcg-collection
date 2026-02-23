# TCG Collection - MongoDB Exercises

A Spring Boot application for learning MongoDB queries through a Trading Card Game collection.

## Prerequisites

- Java 25 or higher
- MongoDB installed and running locally on port 27017
- IntelliJ IDEA

## Setup

### Start MongoDB

Make sure MongoDB is running locally on the default port 27017. The application expects:
- **Host:** localhost
- **Port:** 27017
- **Database:** tcg-collection (created automatically)

### Run the Application

1. Open the project in IntelliJ IDEA
2. Run the `TcgCollectionApplication` class
3. The application starts on port 8080 and loads sample data automatically

### Run Tests

Tests connect to MongoDB on localhost:27017 using a separate test database (`tcg-collection-test`). Make sure MongoDB is running before executing tests.

Run tests from IntelliJ or use Maven:

```bash
./mvnw test
```


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



