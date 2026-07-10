package ir.maktabsharif.discount.model;

import ir.maktabsharif.discount.enums.CouponStatus;

import java.time.LocalDate;

public class Coupon {
    private Long id;
    private String code;
    private Integer discountPercent;
    private Integer maxUsage;
    private Integer usedCount;
    private LocalDate expireDate;
    private CouponStatus status;

    public Coupon(String code, Integer discountPercent, Integer maxUsage, Integer usedCount, LocalDate expireDate, CouponStatus status) {
        this.code = code;
        this.discountPercent = discountPercent;
        this.maxUsage = maxUsage;
        this.usedCount = usedCount;
        this.expireDate = expireDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Integer getMaxUsage() {
        return maxUsage;
    }

    public void setMaxUsage(Integer maxUsage) {
        this.maxUsage = maxUsage;
    }

    public Integer getUsedCount() {
        return usedCount;
    }

    public void setUsedCount(Integer usedCount) {
        this.usedCount = usedCount;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public CouponStatus getStatus() {
        return status;
    }

    public void setStatus(CouponStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("{ID: %d | Code: %s | Percent: %d | Status: " + status + "}",
                id, code, discountPercent);
    }
}
