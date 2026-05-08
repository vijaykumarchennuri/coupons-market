package CuponCodes.CuponCodes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import CuponCodes.CuponCodes.entity.User;
import CuponCodes.CuponCodes.service.UserService;
import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    private UserService service;

    @PostMapping("/signup")
    public String signup(User user, Model model) {

        if(user.getUsername().isEmpty() || user.getPassword().isEmpty()) {

            model.addAttribute("error",
                    "Username and Password are mandatory");

            return "register";
        }

        String result = service.register(user);

        if(result.equals("Registration Successful")) {

            model.addAttribute("success",
                    "Registration Successful. Please Login");

            return "login";
        }

        model.addAttribute("error", result);

        return "register";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model,
                        HttpSession session) {

        if(username.isEmpty() || password.isEmpty()) {

            model.addAttribute("error",
                    "Please enter username and password");

            return "login";
        }

        User user = service.login(username, password);

        if(user == null) {

            model.addAttribute("error",
                    "Invalid Username or Password");

            return "login";
        }

        session.setAttribute("user", user);

        return "redirect:/dashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/";
    }
}