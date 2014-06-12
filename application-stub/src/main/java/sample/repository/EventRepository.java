package sample.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import sample.domain.Event;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {

}
