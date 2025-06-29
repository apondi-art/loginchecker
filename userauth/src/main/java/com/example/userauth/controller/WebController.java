package com.example.userauth.controller;

import com.example.userauth.model.User;
import com.example.userauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    @Autowired
    private UserService userService;

    // 🔹 Show registration form
    // uses GET request
    //show the register form
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // 🔹 Handle registration form submission
    // uses POST request
    //register the user
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        boolean success = userService.registerUser(user);
        if (!success) {
            model.addAttribute("error", "Email already exists!");
            return "register";
        }
        return "redirect:/login?registered";
    }

    // 🔹 Show login page
    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "registered", required = false) String registered,
                            @RequestParam(value = "logout", required = false) String logout,
                            Model model) {
        if (registered != null) {
            model.addAttribute("message", "Registration successful. Please log in.");
        }
        if (logout != null) {
            model.addAttribute("message", "You have been logged out.");
        }
        return "login";
    }

    // 🔹 Welcome page after login
    @GetMapping("/welcome")
    public String welcome(Model model,
                          @SessionAttribute(name = "SPRING_SECURITY_CONTEXT", required = false) Object securityContext) {
        
        model.addAttribute("name", "User"); // replace with actual user name if needed
        return "welcome";
    }
}
