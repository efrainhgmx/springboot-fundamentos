package com.fundamentos.springboot.fundamentos.caseuse;

import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.service.UserService;

import java.util.List;

public class UserRepositoryImplment implements UserRepository {
    private UserService userService;

    public UserRepositoryImplment(UserService userService) {
        this.userService = userService;
    }


    @Override
    public List<User> getAll() {
        return this.userService.getAllUsers();
    }

    @Override
    public void createUser(User user) {
        userService.createUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }
}
