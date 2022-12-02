package com.business.payback.challengeOne.service.mapper;

import com.business.payback.challengeOne.api.dto.CouponMembersItemDto;
import com.business.payback.challengeOne.service.model.CouponMembersItemModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author : Nargess
 * mapper interface class for mapping models
 **/
@Mapper(componentModel = "spring")
public interface MemberCouponsMapper {

    /**
     * map CouponMembersItemModel data to CouponMembersItemDto for top laye
     *
     * @param model : CouponMembersItemModel is source model
     * @return : CouponMembersItemDto is target model
     */
    @Mapping(source = "model.coupon.[0].location", target = "location")
    default CouponMembersItemDto map(CouponMembersItemModel model) {

        CouponMembersItemDto couponMembersItemDto = new CouponMembersItemDto();
        //
        couponMembersItemDto.setLocation(model.getCoupon().get(0).getLocation());
        couponMembersItemDto.setCouponId(model.getCouponId());
        couponMembersItemDto.setCouponMembersId(model.getId());
        couponMembersItemDto.setMemberId(model.getMemberId());
        couponMembersItemDto.setValidFrom(model.getValidFrom());
        couponMembersItemDto.setValidUntil(model.getValidUntil());
        //
        return couponMembersItemDto;
    }


}
