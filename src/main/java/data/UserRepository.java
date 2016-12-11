package data;

import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;


public interface UserRepository extends MongoRepository<User, Integer> {

    List<User> findAll();

    User findByUserName(String userName);

    User findByPhone(String phone);

    User findByMail(String mail);

    boolean exists(int id);
}
