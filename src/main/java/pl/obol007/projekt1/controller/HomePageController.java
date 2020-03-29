package pl.obol007.projekt1.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.obol007.projekt1.domain.model.Business;
import pl.obol007.projekt1.domain.model.Client;
import pl.obol007.projekt1.domain.model.User;
import pl.obol007.projekt1.domain.repositories.BusinessRepository;
import pl.obol007.projekt1.domain.repositories.ClientRepository;
import pl.obol007.projekt1.domain.repositories.UserRepository;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("")
@Slf4j
public class HomePageController {

    UserRepository userRepository;
    BusinessRepository businessRepository;
    ClientRepository clientRepository;

    public HomePageController(UserRepository userRepository,
                              BusinessRepository businessRepository,
                              ClientRepository clientRepository) {
        this.userRepository = userRepository;
        this.businessRepository = businessRepository;
        this.clientRepository = clientRepository;
    }

    @ModelAttribute("categories")
    public List<String> getCategories(){
        {
            return Arrays.asList("fruits", "vegetables","nuts&seeds","grains","legumes&beans");
        }
    }

    @GetMapping
    public String prepareHomePage(Principal principal, Model model) {


//        String username = principal.getName();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String role = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        log.warn("USERNAME: "+username);
        log.warn("ROLA: "+role);

        if (username.equals("anonymousUser")) {
            return "/home/home";


        }
        if (role.equals("[ROLE_CLIENT]")) {
            Client client = clientRepository.findByUsername(username);
            log.debug("UWAGA: CLIENT: "+client);
            model.addAttribute("client",client);
            return "/client/clientMain";
        }
        if(role.equals("[ROLE_BUSINESS]")){
            Business business = businessRepository.findByUsername(username);
            model.addAttribute("business",business);
            return "/business/businessMain";
        }
        log.warn("NIE WYBRAL NIKOGO");
        return "/home/home";


    }
}
