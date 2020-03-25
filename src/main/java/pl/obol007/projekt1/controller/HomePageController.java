package pl.obol007.projekt1.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("")
public class HomePageController {

    @GetMapping
    public String prepareHomePage(){

//        String username = principal.getName();
//        model.addAttribute("username", username);

//metoda statyczna, zadziala w kazdej klasie z realizacja żądania
//        String username2 = SecurityContextHolder.getContext().getAuthentication().getName();
        return "/home/home";
    }
}
