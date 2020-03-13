package com.mybatisMe.service;

import java.util.List;

import com.mybatisMe.entities.User;

public interface UserService {

    User getUserById(int id) throws Exception;

    void createUser(User user) throws Exception;

    void createUsers(List<User> users) throws Exception;
}
