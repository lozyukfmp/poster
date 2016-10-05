package com.lozyukartem.poster.dao;

import com.lozyukartem.poster.entity.User;

public interface UserDao {
    User getUser(String login, String password);

    User addUser(User user);
}
