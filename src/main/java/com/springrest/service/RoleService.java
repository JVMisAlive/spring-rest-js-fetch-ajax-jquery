package com.springrest.service;


import com.springrest.model.Role;
import com.springrest.model.User;

import java.util.List;
import java.util.Set;

public interface RoleService {
    void saveRole(Role role);

    void deleteRole(Role role);

    void updateRole(Role role);

    Role getRoleById(Long id);

    List<Role> getAllRoles();

    Role getRoleByName(String name);

    Set<Role> getRoleSet(Set<String> roles);

    String getViewRoleSet(User user);
}