package com.mutuel.de.sante.Service;

import com.mutuel.de.sante.Model.User;

import java.util.List;

public interface UserInterface {

    User saveUser(User user);
    User UpdateUser(User user);
    void deleteUserById(User user);
    List<User> UserList(String keyword);
    User findUserById(User user);
}
