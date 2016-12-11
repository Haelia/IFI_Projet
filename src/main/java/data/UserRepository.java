package data;

import org.springframework.data.repository.CrudRepository;


import java.util.List;


public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findAll();

    User findByUserName(String userName);

    User findByPhone(String phone);

    User findByMail(String mail);

    boolean exists(int id);
}
