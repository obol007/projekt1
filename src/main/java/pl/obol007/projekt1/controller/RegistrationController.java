package pl.obol007.projekt1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.obol007.projekt1.dto.BusinessRegistrationDTO;
import pl.obol007.projekt1.dto.ClientRegistrationDTO;
import pl.obol007.projekt1.service.BusinessRegistrationService;
import pl.obol007.projekt1.service.ClientRegistrationService;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final BusinessRegistrationService businessRegistrationService;
    private final ClientRegistrationService clientRegistrationService;

    public RegistrationController(BusinessRegistrationService businessRegistrationService,
                                  ClientRegistrationService clientRegistrationService) {
        this.businessRegistrationService = businessRegistrationService;
        this.clientRegistrationService = clientRegistrationService;
    }


    @GetMapping("/businessRegistration")
    public String businessRegistrationPage(Model model){
        model.addAttribute("businessData", new BusinessRegistrationDTO());
        return "/business/businessRegistration";
    }
//========================ALTERNATYWNA WERSJA====================================//
//        public String registrationPage(BusinessRegistrationDTO businessData){  //
//            return "/registration/registration";                               //
//        }                                                                      //
//===============================================================================//

    @PostMapping("/businessRegistration")
    public String businessRegistering(@Valid @ModelAttribute("businessData")
        BusinessRegistrationDTO businessData, BindingResult result){
        if(result.hasErrors()){
            return "/business/businessRegistration";
        }

        businessRegistrationService.registerBusiness(businessData);
        //redirect konczy obsluge zadania
        return "redirect:/login";
    }


    @GetMapping("/clientRegistration")
    public String clientRegistrationPage(Model model){
        model.addAttribute("data", new ClientRegistrationDTO());
        return "/client/clientRegistration";
    }


    @PostMapping("/clientRegistration")
    public String clientRegistering(@Valid @ModelAttribute("data")
         ClientRegistrationDTO data, BindingResult result){
        if(result.hasErrors()){
            return "/client/clientRegistration";
        }

        clientRegistrationService.registerClient(data);
        //redirect konczy obsluge zadania
        return "redirect:/login";
    }

}
