package com.mutuel.de.sante.Service.ServiceImplementation;

import com.mutuel.de.sante.Model.User;
import com.mutuel.de.sante.Repository.UserRepository;
import com.mutuel.de.sante.Service.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserInterface {

    @Autowired
    private UserRepository userRepo;
    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User UpdateUser(User user) {
        User d = findUserById(user);
        if(d!=null){
            d.setId(user.getId());
            d.setfName(user.getfName());
            d.setlName(user.getlName());
            d.setNationalId(user.getNationalId());
            d.setHeadOfFamily(user.getHeadOfFamily());
            d.setEmail(user.getEmail());
            d.setSocialStatus(user.getSocialStatus());
            d.setAddress(user.getAddress());
            return userRepo.save(d);
        }else {
            return saveUser(user);
        }
    }

    @Override
    public void deleteUserById(User user) {
        userRepo.delete(user);
    }

    @Override
    public List<User> UserList(String keyword){
   if (keyword!=null){
        return userRepo.search(keyword);
        }
        return userRepo.findAll();
    }

    @Override
    public User findUserById(User user) {
        return userRepo.findById(user.getId()).get();
    }
}
