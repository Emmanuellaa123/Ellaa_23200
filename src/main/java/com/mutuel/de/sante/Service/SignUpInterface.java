package com.mutuel.de.sante.Service;

import com.mutuel.de.sante.Model.SignUp;

import java.util.List;

public interface SignUpInterface {
    SignUp createUser(SignUp user);
    SignUp updateUser(SignUp user);
    void deleteUser(SignUp user);
    List<SignUp> userlist(SignUp user);
    SignUp getUser(SignUp user);
    SignUp findUserById();
}
