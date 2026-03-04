# TCG Collection - MongoDB Exercises

A Spring Boot application for learning MongoDB queries through a Trading Card Game collection.

## Prerequisites

- Java 25 or higher
- MongoDB installed and running locally on port 27017

## Setup

### 1. Start MongoDB

Make sure MongoDB is running locally on the default port 27017. The application expects:
- **Host:** localhost
- **Port:** 27017
- **Database:** `tcg-collection`

### 2. Run the Application

#### Option A — Maven wrapper (recommended, works with any IDE)

```bash
./mvnw spring-boot:run
```

#### Option B — IntelliJ IDEA (Community & Ultimate)

IntelliJ IDEA **Community Edition** does not include the Spring Boot plugin, so there is no
dedicated Spring Boot run configuration. You can still run the application by creating a
standard **Application** run configuration:

1. Open the project in IntelliJ IDEA and wait for the Maven import to complete
2. Go to **Run → Edit Configurations… → + → Application**
3. Set the following fields:
    - **Name:** `TcgCollectionApplication`
    - **Module / classpath:** `tcg-collection`
    - **Main class:** `it.sergas.andrea.tcgcollection.TcgCollectionApplication`
4. Click **Apply → OK**, then run it with the green ▶ button

> **Tip:** Make sure annotation processing is enabled
> (**Settings → Build → Compiler → Annotation Processors → Enable annotation processing**),
> otherwise Lombok and MapStruct will not work correctly.

#### Option C — Executable JAR

```bash
./mvnw clean package -DskipTests
java -jar target/tcg-collection-1.0.0.jar
```

### 3. Initial Data Loading

The database and its collections are created **automatically on the first application startup**.
A component (`TcgDataInitializer`) checks each collection: if it is empty, it loads the
corresponding sample data from `src/main/resources/data/*.json`. There is no need to manually
import data or create collections in MongoDB.

### 4. Run Tests

Tests connect to MongoDB on localhost:27017 using a separate test database (`tcg-collection-test`).
Make sure MongoDB is running before executing tests.

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



