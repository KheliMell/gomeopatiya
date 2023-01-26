package web.service;

import web.model.Role;

import java.util.List;

public interface RoleService {
    Role getRoleById(Integer id);

    List<Role> getAllRoles();

    void saveRole(Role role);