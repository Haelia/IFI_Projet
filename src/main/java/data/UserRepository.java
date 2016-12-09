package data;

import org.springframework.data.repository.CrudRepository;


import java.util.List;


public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findAll();

    User findByFirstNameAndLastName(String firstName, String lastName);

    User findByPhone(String phone);

    User findByEmail(String email);

    boolean exists(int id);
}
