package it.sergas.andrea.tcgcollection.repositories;

import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.mongodb.test.autoconfigure.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;

@DataMongoTest
@ActiveProfiles(profiles = "test")
public abstract class BaseRepositoryTest {

    @Autowired protected MongoTemplate mongoTemplate;

    @AfterEach
    void cleanUp() {
        mongoTemplate.getDb().drop();
    }
}
