package ir.maktabsharif.discount.repository.impl;

import ir.maktabsharif.discount.enums.CouponStatus;
import ir.maktabsharif.discount.exception.DatabaseConnectionException;
import ir.maktabsharif.discount.model.Coupon;
import ir.maktabsharif.discount.repository.CouponRepository;
import ir.maktabsharif.discount.util.DatabaseConfig;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class CouponRepositoryImpl implements CouponRepository {
    @Override
    public Long insert(Coupon coupon) {
        String query = "insert into coupons (code, discount_percent, max_usage, used_usage, expire_date, status)" +
                " VALUES (?,?,?,?,?,?)  returning id;";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)
        ) {
            ps.setString(1, coupon.getCode());
            ps.setInt(2, coupon.getDiscountPercent());
            ps.setInt(3, coupon.getMaxUsage());
            ps.setInt(4, coupon.getUsedCount());
            ps.setDate(5, Date.valueOf(coupon.getExpireDate()));
            ps.setString(6, coupon.getStatus().toString());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getLong("id");
                }
                return -1L;
            }

        } catch (SQLException e) {
            throw new DatabaseConnectionException("Could not connect to database : " + e.getMessage());
        }
    }

    @Override
    public Optional<Coupon> findById(Long id) {
        String query = "select * from coupons where id = ?;";
        try(Connection connection = DatabaseConfig.getConnection();
        PreparedStatement ps = connection.prepareStatement(query)){
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                   return Optional.of(new Coupon(
                           rs.getLong(1),
                           rs.getString(2),
                           rs.getInt(3),
                           rs.getInt(4),
                           rs.getInt(5),
                           rs.getDate(6).toLocalDate(),
                           CouponStatus.valueOf(rs.getString(7)))
                   );
                }
                return Optional.empty();
            }

        } catch (SQLException e) {
            throw new DatabaseConnectionException("Could not connect to database : " + e.getMessage());
        }
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
