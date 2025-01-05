package gr.aueb.cf.cf6finalproject.controller;

import gr.aueb.cf.cf6finalproject.dto.UserDTO;
import gr.aueb.cf.cf6finalproject.entity.User;
import gr.aueb.cf.cf6finalproject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Tag(name = "Auth", description = "Authentication and Registration Endpoints")
@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Home Page", description = "Displays the home page.")
    @GetMapping("/index")
    public String home() {
        return "index";
    }

    @Operation(summary = "Login Page", description = "Displays the login page.")

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @Operation(summary = "Registration Page", description = "Displays the registration form.")
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "register";
    }

    @Operation(summary = "Register User", description = "Handles user registration.")
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDTO user,
                               BindingResult bindingResult,
                               Model model) {
        User existingUser = userService.findUserByEmail(user.getEmail());
        if (existingUser != null) {
            bindingResult.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if (bindingResult.hasErrors()) {
            return "register";
        }

        userService.saveUser(user);
        return "redirect:/register?success";
    }

    @Operation(summary = "User Management Page", description = "Displays the list of all users.")
    @GetMapping("/users")
    public String users(Model model) {
        List<UserDTO> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @Operation(summary = "Main Page", description = "Displays the foods page.")
    @GetMapping("/mainpage")
    public String mainPage() {
        return "foods";
    }


}
