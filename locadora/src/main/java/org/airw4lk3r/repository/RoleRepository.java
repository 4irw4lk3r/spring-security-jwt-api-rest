package org.airw4lk3r.repository;

import java.util.Optional;

import org.airw4lk3r.model.Role;
import org.airw4lk3r.model.RoleName;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
	Optional<Role> findByName(RoleName roleName);
}
