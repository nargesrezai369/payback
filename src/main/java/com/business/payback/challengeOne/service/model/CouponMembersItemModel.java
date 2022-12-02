package com.business.payback.challengeOne.service.model;

import com.business.payback.challengeOne.database.entity.CouponEntity;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author : Nargess
 * @since : 11/28/2022, Mon
 **/

@Data
public class CouponMembersItemModel {

    private String id;

    private String couponId;

    private String memberId;

    private LocalDateTime validFrom;

    private LocalDateTime validUntil;

    private List<CouponEntity> coupon;

}
