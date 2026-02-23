package it.sergas.andrea.tcgcollection.repositories;

import it.sergas.andrea.tcgcollection.entities.LorcanaCard;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for managing LorcanaCard entities.
 */
@Repository
public interface LorcanaCardRepository
        extends MongoRepository<LorcanaCard, ObjectId> {

    /**
     * Finds Lorcana cards by ink color.
     *
     * @param inkColor the ink color to search for
     * @return list of Lorcana cards with the specified ink color
     */
    @Query("{}") // TODO: implement me
    List<LorcanaCard> findByInkColor(String inkColor);

    /**
     * Finds Lorcana cards by franchise title.
     *
     * @param franchiseTitle the franchise title to search for
     * @return list of Lorcana cards with the specified franchise title
     */
    @Query("{}") // TODO: implement me
    List<LorcanaCard> findByFranchiseTitle(String franchiseTitle);
}
