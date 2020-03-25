package pl.obol007.projekt1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/business")
public class BusinessController {

    @GetMapping("/register")
    public String register() {
        return "/business/businessRegistration";
    }

    @GetMapping("")
    public String mainBusinessPage(){
        return "businessMain";
    }
}
