package data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PeopleRepository extends CrudRepository<People, Integer> {

    People save(People people);

    List<People> findAll();

    People findByFirstNameAndLastName(String firstName, String lastName);

    People findByPhone(String phone);

    People findByEmail(String email);

    long count();

    void delete(People people);

    boolean exists(Long id);
}
