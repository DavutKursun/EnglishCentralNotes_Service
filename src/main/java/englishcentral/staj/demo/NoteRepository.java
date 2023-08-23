package englishcentral.staj.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface NoteRepository extends MongoRepository<Note,String> {

    @Query("{'userId' : ?0}")
    List<Note> findByUserId(String userId);


    Long deleteNoteByUserId(String userId);
}
