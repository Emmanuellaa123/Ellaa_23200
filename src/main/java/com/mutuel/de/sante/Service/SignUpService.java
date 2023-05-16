package com.mutuel.de.sante.Service;

import com.mutuel.de.sante.Model.SignUp;
import com.mutuel.de.sante.Repository.SignUpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignUpService implements SignUpInterface{
    @Autowired
    private final SignUpRepo signUpRepo;



    public SignUpService(SignUpRepo signUpRepo) {
        this.signUpRepo = signUpRepo;
    }

    @Override
    public SignUp createUser(SignUp user) {
        return signUpRepo.save(user);
    }

    @Override
    public SignUp updateUser(SignUp user) {
        SignUp users = findUserById();
        if (users != null) {
            users.setId((user.getId()));
            users.setEmail(user.getEmail());
            users.setPassword(user.getPassword());
            return signUpRepo.save(users);
        } else {
            return createUser(user);
        }
    }

    @Override
    public void deleteUser(SignUp user) { signUpRepo.deleteAll();

    }

    @Override
    public List<SignUp> userlist(SignUp user) {
        return signUpRepo.findAll();
    }

    @Override
    public SignUp getUser(SignUp user) {
        return signUpRepo.findByEmailAndPassword(user.getEmail(),user.getPassword()).orElse(null);
    }

    @Override
    public SignUp findUserById() {
        return null;
    }
}
