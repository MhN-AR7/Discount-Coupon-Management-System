package ir.maktabsharif.discount.repository;

import ir.maktabsharif.discount.model.Coupon;

import java.util.List;

public interface CouponRepository {
    Long insert(Coupon coupon);
    Coupon findById(Long id);
    List<Coupon> findAll();
    boolean existCoupon(String code);
}
