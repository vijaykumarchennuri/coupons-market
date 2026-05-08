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

    public Coupon saveCoupon(Coupon coupon) {
        return repository.save(coupon);
    }

    public List<Coupon> getAllCoupons() {
        return repository.findAll();
    }

    public List<Coupon> getByCategory(String category) {
        return repository.findByCategory(category);
    }

    public void deleteCoupon(Long id) {
        repository.deleteById(id);
    }

    public Coupon getById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public String maskCoupon(String code) {

        if(code == null || code.length() <= 2) {
            return code;
        }

        String firstTwo = code.substring(0, 2);

        String stars = "*".repeat(code.length() - 2);

        return firstTwo + stars;
    }
}