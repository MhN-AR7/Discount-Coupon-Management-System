package ir.maktabsharif.discount.repository.impl;

import ir.maktabsharif.discount.model.Coupon;
import ir.maktabsharif.discount.repository.CouponRepository;

import java.util.List;

public class CouponRepositoryImpl implements CouponRepository {
    @Override
    public Long insert(Coupon coupon) {
        return 0L;
    }

    @Override
    public Coupon findById(Long id) {
        return null;
    }

    @Override
    public List<Coupon> findAll() {
        return List.of();
    }

    @Override
    public boolean existCoupon(String code) {
        return false;
    }
}
