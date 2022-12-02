package com.business.payback.challengeOne.api.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.time.LocalDateTime;

/**
 * @author : Nargess
 * this class is output dto in controller for each member's coupon that is found
 **/

@Data
public class CouponMembersItemDto {

    /**
     * each coupon that is assigned to member is in couponMembers collection and has a unique id
     */
    private String couponMembersId;

    /**
     * each coupon has a unique id
     */
    private String couponId;

    /**
     * each member has a unique id
     */
    private String memberId;

    /**
     * each coupon has a validFrom date that coupon has validated from it
     */
    private LocalDateTime validFrom;

    /**
     * each coupon has a validUntil date that coupon is validated until it
     */
    private LocalDateTime validUntil;

    /**
     * each member has location (x,y)
     */
    private GeoJsonPoint location;


}
