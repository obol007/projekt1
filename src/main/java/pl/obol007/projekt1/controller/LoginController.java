package pl.obol007.projekt1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.obol007.projekt1.domain.model.Business;
import pl.obol007.projekt1.domain.model.Client;
import pl.obol007.projekt1.domain.model.User;
import pl.obol007.projekt1.domain.repositories.UserRepository;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@Controller
public class LoginController {

    UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @GetMapping("/login")
    public String prepareLoginPage(Principal principal){
        if(principal==null) {
            return "login/form";
        }
        else{
            String username = principal.getName();
            User user = userRepository.findByUsername(username);
            String role = user.getRole();
            if (role.equals("ROLE_BUSINESS")) {
                return "redirect:/business";
            } else {

                return "redirect:/client";
            }
        }
    }




}
