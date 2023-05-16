package com.mutuel.de.sante.Controller;

import com.mutuel.de.sante.Model.User;
import com.mutuel.de.sante.Repository.UserRepository;
import com.mutuel.de.sante.Service.ServiceImplementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserRepository repo;
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/registerUser")
    public String getFirstPage(Model model){
        model.addAttribute("userRequest", new User());
        model.addAttribute("registerPage", "New User");
        return "register_page";
    }

    @GetMapping("/display")
    public String UserList(Model model, @Param("keyword") String keyword){
        List<User>ListOfUsers = userService.UserList(keyword);
        model.addAttribute("ListOfUsers", ListOfUsers);

        return "Display";
    }

    @PostMapping("/saveUser")
    public String SaveUser(@ModelAttribute User user){
        System.out.println("SaveUser request :" + user);
      User registerUser = userService.saveUser(user);
      return  registerUser == null ? "error_page" : "redirect:/personal";
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Integer id, Model model){
        Optional<User> Mydata = repo.findFirstById(id);
        User user= Mydata.get();
        model.addAttribute("user", user);
        return "Update_Page";
    }

    @GetMapping("/Delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        repo.deleteById(id);
        return "redirect:/display";
    }
   @GetMapping ("/personal")
    public String personal_page(Model model){
        model.addAttribute("requestPersonalPage" , new User());
        return "personal_page";
   }

}
