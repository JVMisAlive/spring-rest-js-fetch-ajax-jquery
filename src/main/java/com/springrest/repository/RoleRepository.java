package com.springrest.repository;

import com.springrest.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getRoleByName(String name);

    Set<Role> getRoleByNameIn(Set<String> set);
}
