package com.business.payback.challengeOne.api.controller;

import com.business.payback.challengeOne.api.dto.CouponMembersItemDto;
import com.business.payback.challengeOne.api.dto.GetMemberCouponsDto;
import com.business.payback.challengeOne.service.MemberCouponService;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Nargess
 * this controller is for coupons that asign to member
 * you can call it's rests by using localhost:8080/payback/memberCoupon*
 **/

@RestController
@RequestMapping("/payback/memberCoupon")
@AllArgsConstructor //Constructor Injection
public class PayBackMemberCouponController {

    private final MemberCouponService memberCouponService;

    /**
     * this rest is for get list of coupons that assign to member by memberId
     *
     * @param dto :
     *            you should fill the memberId for get list of coupons for that member
     *            you should fill the sortField for sorting your list base on nearest location or validUntil descending
     * @return list of CouponMembersItemDto that include couponMembersId, couponId, memberId, validFrom, validUntil
     * * and location;
     */
    @GetMapping
    public List<CouponMembersItemDto> getMemberCoupons(GetMemberCouponsDto dto) throws ChangeSetPersister.NotFoundException {

        //call getMemberCoupons from MemberCouponService class for getting member's coupon
        return memberCouponService.getMemberCoupons(dto);
    }

}
