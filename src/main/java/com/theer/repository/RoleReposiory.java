package com.theer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theer.domain.Role;

@Repository
public interface RoleReposiory extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
