package pl.obol007.projekt1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.obol007.projekt1.dto.RegistrationDataDTO;
import pl.obol007.projekt1.service.RegistrationService;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    @GetMapping
    public String registrationPage(Model model){
//        to samo co model.addAttribute
//    public String registrationPage(RegistrationDataDTO data){
        model.addAttribute("data", new RegistrationDataDTO());
        return "/registration/registration";
    }

    @PostMapping
    public String procesRegistration(@Valid @ModelAttribute("data")
        RegistrationDataDTO data, BindingResult result){
        if(result.hasErrors()){
            return "registration";
        }

        registrationService.registerUser(data);
        //redirect konczy obsluge zadania
        return "redirect:/login";
    }

}
