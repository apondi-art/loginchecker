package com.example.userauth.controller;

import com.example.userauth.model.User;
import com.example.userauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class WebController {

    @Autowired
    private UserService userService;

    // 🔹 Show registration form
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // 🔹 Handle registration form submission
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

    // 🔹 Welcome page after login (shows full name)
    @GetMapping("/welcome")
    public String welcome(Model model, Principal principal) {
        String email = principal.getName(); // Email used to log in
        User user = userService.findByEmail(email); // Get user from DB

        String fullName = user.getFirstName() + " " + user.getLastName();
        model.addAttribute("fullName", fullName); // Send to view

        return "welcome";
    }
}
