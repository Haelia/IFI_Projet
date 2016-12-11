package data;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, Integer> {

    List<Message> findAll();

    Message findByUser(User user);
}
