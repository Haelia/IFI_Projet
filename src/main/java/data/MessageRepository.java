package data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, Integer> {

    List<Message> findAll();

    Page<Message> findAll(Pageable pageable);

    List<Message> findByUser(User user);
}
