package com.business.payback.challengeOne.database.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * @author : Nargess
 * this class is a coupon entity in dtabase for saving coupons that assign to members
 **/

@Data
@Document("couponMembers")//document name in database
public class CouponMembersEntity {

    /**
     * each coupon that is assigned to member is in couponMembers collection and has a unique id
     */
    @Id
    private String id;

    /**
     * each coupon has a unique id , from coupon entity
     */
    private String couponId;

    /**
     * each member has a unique id , from member entity
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
}
