package com.epam.marketspring.servingwebcontent;

import com.epam.marketspring.domain.User;
import com.epam.marketspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class SignUpController {

    @Autowired
    private UserService userService;


    @GetMapping("/signup")
    public String registration(Model model) {

        return "signUpPage";
    }

    @PostMapping("/signup")
    public String reg(@Valid User user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("error", "ALL FIELDS MUST BE FULLFILLED");
            return "signUpPage";
        }

        if (userService.ifUserExists(user.getUsername())) {
            return "invalidRegistration";
        } else {
            userService.addUser(user);
            return "redirect:/login";
        }

    }

}