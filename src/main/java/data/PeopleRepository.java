package data;

import org.springframework.data.repository.CrudRepository;


import java.util.List;


public interface PeopleRepository extends CrudRepository<People, Integer> {

    List<People> findAll();

    People findByFirstNameAndLastName(String firstName, String lastName);

    People findByPhone(String phone);

    People findByEmail(String email);

    boolean exists(int id);
}
