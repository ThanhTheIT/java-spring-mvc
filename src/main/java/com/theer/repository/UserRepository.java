package com.theer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theer.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User save(User theer);

    List<User> findByEmail(String email);

}
