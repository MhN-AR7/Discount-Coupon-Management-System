package ir.maktabsharif.discount.repository;

import ir.maktabsharif.discount.model.Coupon;

import java.util.List;
import java.util.Optional;

public interface CouponRepository {
    Long insert(Coupon coupon);
    Optional<Coupon> findById(Long id);
    List<Coupon> findAll();
    boolean existCoupon(String code);
}
