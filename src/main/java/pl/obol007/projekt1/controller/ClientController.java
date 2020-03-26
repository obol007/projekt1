package pl.obol007.projekt1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.obol007.projekt1.domain.model.Business;
import pl.obol007.projekt1.domain.model.Client;
import pl.obol007.projekt1.domain.model.User;
import pl.obol007.projekt1.domain.repositories.ClientRepository;
import pl.obol007.projekt1.domain.repositories.UserRepository;

import java.security.Principal;

@Controller
@RequestMapping("/client")
public class ClientController {

    UserRepository userRepository;
    ClientRepository clientRepository;

    public ClientController(UserRepository userRepository, ClientRepository clientRepository) {
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
    }

    @GetMapping("/register")
    public String register() {
        return "/client/clientRegistration";
    }

    @GetMapping()
    public String mainClientPage(Principal principal, Model model) {
        String username = principal.getName();
        User user = userRepository.findByUsername(username);
        Client client = clientRepository.findByUserId(user.getId());
        model.addAttribute("client", client);
        model.addAttribute("loggedUser",client.getFirstName());
        return "/client/clientMain";
    }
}