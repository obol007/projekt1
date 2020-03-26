package pl.obol007.projekt1.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.obol007.projekt1.domain.model.Business;
import pl.obol007.projekt1.domain.model.Client;
import pl.obol007.projekt1.domain.model.User;
import pl.obol007.projekt1.domain.repositories.BusinessRepository;
import pl.obol007.projekt1.domain.repositories.ClientRepository;
import pl.obol007.projekt1.domain.repositories.UserRepository;

import java.security.Principal;

@Controller
@RequestMapping("/selectRole")
public class SelectRoleController {

    UserRepository userRepository;
    BusinessRepository businessRepository;
    ClientRepository clientRepository;

    public SelectRoleController(UserRepository userRepository,
                                BusinessRepository businessRepository,
                                ClientRepository clientRepository) {
        this.userRepository = userRepository;
        this.businessRepository = businessRepository;
        this.clientRepository = clientRepository;
    }


    @GetMapping
    public String choose(Principal principal, Model model) {
        String username = principal.getName();
        User user = userRepository.findByUsername(username);
        String role = user.getRole();
        if (role.equals("BUSINESS")) {
            Business business = businessRepository.findByUserId(user.getId());
            model.addAttribute("business", business);

            return "business/businessMain";
        } else {
            Client client = clientRepository.findByUserId(user.getId());
            model.addAttribute("client", client);

            return "/client/clientMain";
        }


    }


}
