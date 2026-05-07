package CuponCodes.CuponCodes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CuponCodes.CuponCodes.dto.CouponDTO;
import CuponCodes.CuponCodes.entity.Coupon;
import CuponCodes.CuponCodes.entity.User;
import CuponCodes.CuponCodes.service.CouponService;
import CuponCodes.CuponCodes.service.UserService;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    private CouponService service;

    @Autowired
    private UserService userService;

    @PostMapping("/add/{userId}")
    public Coupon addCoupon(@RequestBody Coupon coupon, @PathVariable Long userId) {

        User user = userService.getUserById(userId);
        coupon.setUser(user);

        return service.addCoupon(coupon);
    }

    @PutMapping("/update/{id}")
    public Coupon updateCoupon(@PathVariable Long id, @RequestBody Coupon updated) {

        Coupon existing = service.getById(id);

        existing.setTitle(updated.getTitle());
        existing.setCouponCode(updated.getCouponCode());
        existing.setPrice(updated.getPrice());
        existing.setPhoneNumber(updated.getPhoneNumber());

        return service.addCoupon(existing);
    }



    @GetMapping("/all")
    public List<CouponDTO> getAllCoupons() {

        return service.getAllCoupons().stream().map(c -> {

            CouponDTO dto = new CouponDTO();
            dto.setId(c.getId());

            dto.setTitle(c.getTitle());
            dto.setCouponCode(service.maskCoupon(c.getCouponCode()));
            dto.setPrice(c.getPrice());
            dto.setPhoneNumber(c.getPhoneNumber());

            if (c.getUser() != null) {
                dto.setUsername(c.getUser().getUsername());
            }

            return dto;

        }).toList();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCoupon(@PathVariable Long id) {
        service.deleteCoupon(id);
        return "Deleted";
    }
}