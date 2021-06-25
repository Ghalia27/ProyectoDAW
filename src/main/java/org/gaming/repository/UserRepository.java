package org.gaming.repository;

import java.util.Optional;

import org.gaming.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	public Optional<User> findByUsername(String username);
}
