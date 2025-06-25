package com.theer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.theer.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User save(User theer);
}
