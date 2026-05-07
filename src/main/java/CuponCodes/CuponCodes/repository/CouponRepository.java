package CuponCodes.CuponCodes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import CuponCodes.CuponCodes.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
