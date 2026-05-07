package CuponCodes.CuponCodes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CuponCodes.CuponCodes.entity.Coupon;
import CuponCodes.CuponCodes.repository.CouponRepository;

@Service
public class CouponService {

    @Autowired
    private CouponRepository repository;

    public Coupon addCoupon(Coupon coupon) {
        return repository.save(coupon);
    }

    public Coupon getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Coupon> getAllCoupons() {
        return repository.findAll();
    }

    public String maskCoupon(String code) {
        if (code.length() <= 3) return code;
        return code.substring(0, 3) + "X".repeat(code.length() - 3);
    }

    public void deleteCoupon(Long id) {
        repository.deleteById(id);
    }
}