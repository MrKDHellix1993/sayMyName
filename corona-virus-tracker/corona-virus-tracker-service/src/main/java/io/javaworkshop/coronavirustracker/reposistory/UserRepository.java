package io.javaworkshop.coronavirustracker.reposistory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import io.javaworkshop.coronavirustracker.accessingdatajpa.Users;

public interface UserRepository extends CrudRepository<Users, Long> {
  List<Users> findByLastName(String lastName);
  
  Users findById(long id);
  
  Optional<Users> findByEmail(String email);
}