package CuponCodes.CuponCodes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }



    @GetMapping("/addCoupon")
    public String addCouponPage() {
        return "addCoupon";
    }
}