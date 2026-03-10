package it.sergas.andrea.tcgcollection;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.springframework.boot.SpringApplication.run;

/**
 * Main Spring Boot application class for the TCG Collection Management System.
 * This application manages collections of trading cards from various games including
 * Pokémon, Yu-Gi-Oh!, Magic: The Gathering, One Piece, and Disney Lorcana.
 */
@SpringBootApplication
public class TcgCollectionApplication {

    /**
     * Main entry point for the Spring Boot application.
     *
     * @param args command-line arguments
     */
    public static void main(final String[] args) {
        run(TcgCollectionApplication.class, args);
    }
}
