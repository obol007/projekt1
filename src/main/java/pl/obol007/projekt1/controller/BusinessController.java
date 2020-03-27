package pl.obol007.projekt1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.obol007.projekt1.domain.model.Business;
import pl.obol007.projekt1.domain.model.User;
import pl.obol007.projekt1.domain.repositories.BusinessRepository;
import pl.obol007.projekt1.domain.repositories.UserRepository;

import java.security.Principal;

@Controller
@RequestMapping("/business")
public class BusinessController {

    UserRepository userRepository;
    BusinessRepository businessRepository;

    public BusinessController(UserRepository userRepository,
                              BusinessRepository businessRepository) {
        this.userRepository = userRepository;
        this.businessRepository = businessRepository;
    }



    @GetMapping("/register")
    public String register() {
        return "/business/businessRegistration";
    }

    @GetMapping
    public String mainBusinessPage(Principal principal, Model model) {

        String username = principal.getName();
        User user = userRepository.findByUsername(username);
        Business business = businessRepository.findByUserId(user.getId());
        model.addAttribute("business", business);
        model.addAttribute("loggedUser",business.getFirstName());

        return "/business/businessMain";
    }
}

