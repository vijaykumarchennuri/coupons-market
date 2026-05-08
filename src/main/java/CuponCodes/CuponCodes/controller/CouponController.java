package CuponCodes.CuponCodes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import CuponCodes.CuponCodes.entity.Coupon;
import CuponCodes.CuponCodes.entity.User;
import CuponCodes.CuponCodes.service.CouponService;
import jakarta.servlet.http.HttpSession;

@Controller
public class CouponController {

    @Autowired
    private CouponService service;

    // ================= DASHBOARD =================

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        List<Coupon> coupons = service.getAllCoupons();

        // MASK COUPON CODES
        for(Coupon c : coupons) {

            c.setCouponCode(
                    service.maskCoupon(c.getCouponCode())
            );
        }

        model.addAttribute("coupons", coupons);

        return "dashboard";
    }

    // ================= CATEGORY FILTER =================

    @GetMapping("/category/{name}")
    public String category(@PathVariable String name,
                           Model model) {

        List<Coupon> coupons =
                service.getByCategory(name);

        // MASK COUPON CODES
        for(Coupon c : coupons) {

            c.setCouponCode(
                    service.maskCoupon(c.getCouponCode())
            );
        }

        model.addAttribute("coupons", coupons);

        return "dashboard";
    }

    // ================= ADD COUPON =================

    @PostMapping("/addCoupon")
    public String addCoupon(Coupon coupon,
                            HttpSession session,
                            Model model) {

        // MOBILE VALIDATION
        if(coupon.getPhoneNumber() == null ||
           !coupon.getPhoneNumber().matches("\\d{10}")) {

            model.addAttribute("error",
                    "Mobile number must contain exactly 10 digits");

            List<Coupon> coupons = service.getAllCoupons();

            for(Coupon c : coupons) {

                c.setCouponCode(
                        service.maskCoupon(c.getCouponCode())
                );
            }

            model.addAttribute("coupons", coupons);

            return "dashboard";
        }

        User user =
                (User) session.getAttribute("user");

        coupon.setUser(user);

        service.saveCoupon(coupon);

        model.addAttribute("success",
                "Coupon Added Successfully");

        List<Coupon> coupons = service.getAllCoupons();

        // MASK COUPON CODES
        for(Coupon c : coupons) {

            c.setCouponCode(
                    service.maskCoupon(c.getCouponCode())
            );
        }

        model.addAttribute("coupons", coupons);

        return "dashboard";
    }

    // ================= DELETE COUPON =================

    @GetMapping("/delete/{id}")
    public String deleteCoupon(@PathVariable Long id,
                               HttpSession session) {

        User user =
                (User) session.getAttribute("user");

        Coupon coupon = service.getById(id);

        // ONLY OWNER CAN DELETE
        if(coupon != null &&
           coupon.getUser().getUsername()
           .equals(user.getUsername())) {

            service.deleteCoupon(id);
        }

        return "redirect:/dashboard";
    }

    // ================= EDIT PAGE =================

    @GetMapping("/edit/{id}")
    public String editCoupon(@PathVariable Long id,
                             Model model,
                             HttpSession session) {

        User user =
                (User) session.getAttribute("user");

        Coupon coupon = service.getById(id);

        // ONLY OWNER CAN EDIT
        if(coupon != null &&
           coupon.getUser().getUsername()
           .equals(user.getUsername())) {

            model.addAttribute("coupon", coupon);

            return "editCoupon";
        }

        return "redirect:/dashboard";
    }

    // ================= UPDATE COUPON =================

    @PostMapping("/updateCoupon")
    public String updateCoupon(Coupon coupon,
                               HttpSession session,
                               Model model) {

        // MOBILE VALIDATION
        if(coupon.getPhoneNumber() == null ||
           !coupon.getPhoneNumber().matches("\\d{10}")) {

            model.addAttribute("error",
                    "Mobile number must contain exactly 10 digits");

            model.addAttribute("coupon", coupon);

            return "editCoupon";
        }

        User user =
                (User) session.getAttribute("user");

        coupon.setUser(user);

        service.saveCoupon(coupon);

        return "redirect:/dashboard";
    }
}