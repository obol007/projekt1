package pl.obol007.projekt1.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.obol007.projekt1.domain.model.Business;
import pl.obol007.projekt1.domain.model.User;
import pl.obol007.projekt1.domain.repositories.BusinessRepository;
import pl.obol007.projekt1.domain.repositories.ClientRepository;
import pl.obol007.projekt1.domain.repositories.UserRepository;
import pl.obol007.projekt1.dto.AddressDTO;
import pl.obol007.projekt1.service.AddressService;

import java.security.Principal;

@Controller
@RequestMapping("/address")
public class AddressController {

    UserRepository userRepository;
AddressService addressService;

    public AddressController(UserRepository userRepository, AddressService addressService) {
        this.userRepository = userRepository;
        this.addressService = addressService;
    }


    @GetMapping("/add")
    public String addAddress(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);

        AddressDTO addressDTO = addressService.findAddress(user.getId());
        model.addAttribute("addressDTO",addressDTO);

        return "/home/address";
        }


    @PostMapping("/add")
    public String addingAddress(AddressDTO addressDTO) {
        addressService.save(addressDTO);


        return "redirect:/selectRole";
    }


}
