package data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Integer> {

    List<Message> findAll();

    Message findByUser(User user);
}
