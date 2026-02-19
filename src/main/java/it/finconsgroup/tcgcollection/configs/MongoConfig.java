package it.finconsgroup.tcgcollection.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * MongoDB configuration class.
 * Configures repository scanning.
 */
@Configuration
@EnableMongoRepositories(basePackages = "it.finconsgroup.tcgcollection.repositories")
public class MongoConfig {}
