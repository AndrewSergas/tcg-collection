package it.sergas.andrea.tcgcollection.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * MongoDB configuration class.
 * Configures repository scanning.
 */
@Configuration
@EnableMongoRepositories(basePackages = "it.sergas.andrea.tcgcollection.repositories")
public class MongoConfig {}
