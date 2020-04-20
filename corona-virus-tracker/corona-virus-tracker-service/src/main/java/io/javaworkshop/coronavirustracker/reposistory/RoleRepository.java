
package io.javaworkshop.coronavirustracker.reposistory;

import org.springframework.data.repository.CrudRepository;
import io.javaworkshop.coronavirustracker.accessingdatajpa.Role;

public interface RoleRepository extends CrudRepository<Role, String> {
	Role findByRole(String role);
}