package com.mutuel.de.sante.Controller;

import com.mutuel.de.sante.Model.SignUp;
import com.mutuel.de.sante.Service.ServiceImplementation.UserServiceImpl;
import com.mutuel.de.sante.Service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {
@Autowired
    private final SignUpService signUpService;
@Autowired
    SignUpService sign;

    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @GetMapping("/")
    public String homePage(Model model){
        return "index";

    }

    @GetMapping("/register")
    public String RegisterPage(Model model){
        model.addAttribute("registerRequest", new SignUp());
        return "SignUp";
    }
    @GetMapping("/login")
    public String LoginPage(Model model){
        model.addAttribute("loginRequest", new SignUp());
        return "LogIn";
    }




    @PostMapping("/save")
    public String saveUser(@ModelAttribute SignUp user){
       System.out.println("request register:" + user);
       SignUp saveUser= signUpService.createUser(user);
       return saveUser == null ? "error_page" : "redirect:/login";

    }

    @PostMapping("/login")
    public String Login(@ModelAttribute SignUp signUp, Model model){
       System.out.println("Login Request: " + signUp);
       SignUp authenticate = signUpService.getUser(signUp);

       if (authenticate!= null){
           model.addAttribute("userLogin", authenticate.getEmail());
           return "register_page";
       }else {
           return "error_page";
       }
    }

}
