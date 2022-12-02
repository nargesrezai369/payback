package com.business.payback.challengeOne.service;

import com.business.payback.challengeOne.api.dto.CouponMembersItemDto;
import com.business.payback.challengeOne.api.dto.GetMemberCouponsDto;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Nargess
 * this is interface for MemberCoupon class that the main business are implemented in it
 **/
@Service
public interface MemberCouponService {

    /**
     * this method is for getting member's coupons base on memberId and sort field
     *
     * @param dto memberId: is unique id for each member
     *            sortField: if you select location the list is sorting base on nearest location and if you select
     *            validUntil the list is sorting base on validUntil for each coupon descending
     * @return list of CouponMembersItemDto that include couponMembersId, couponId, memberId, validFrom, validUntil
     * and location;
     */
    List<CouponMembersItemDto> getMemberCoupons(GetMemberCouponsDto dto) throws ChangeSetPersister.NotFoundException;

}
