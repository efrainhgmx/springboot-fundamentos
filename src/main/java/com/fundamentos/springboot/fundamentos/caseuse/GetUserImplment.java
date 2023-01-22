package com.fundamentos.springboot.fundamentos.caseuse;

import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.service.UserService;

import java.util.List;

public class GetUserImplment implements GetUser{
    private UserService userService;

    public GetUserImplment(UserService userService) {
        this.userService = userService;
    }


    @Override
    public List<User> getAll() {
        return this.userService.getAllUsers();
    }
}
