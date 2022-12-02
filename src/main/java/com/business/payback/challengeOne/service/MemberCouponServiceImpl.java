package com.business.payback.challengeOne.service;

import com.business.payback.challengeOne.api.dto.CouponMembersItemDto;
import com.business.payback.challengeOne.api.dto.GetMemberCouponsDto;
import com.business.payback.challengeOne.database.entity.MemberEntity;
import com.business.payback.challengeOne.database.repository.CouponMembersRepository;
import com.business.payback.challengeOne.database.repository.MemberRepository;
import com.business.payback.challengeOne.service.mapper.MemberCouponsMapper;
import com.business.payback.challengeOne.service.model.CouponMembersItemModel;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author : Nargess
 * this class is main class for implement our business and contain method that is related to member's coupon
 **/
@Service
@AllArgsConstructor
public class MemberCouponServiceImpl implements MemberCouponService {

    /**
     * for accessing to DB and collections because of save, update , ...
     */
    private final CouponMembersRepository couponMembersRepository;

    /**
     * for accessing to DB and collections because of save, update , ...
     */
    private final MemberRepository memberRepository;

    /**
     * mapper class for map dataBase models to dto for top layer
     */
    private final MemberCouponsMapper memberCouponsMapper;

    /**
     * this method is for getting member's coupons base on memberId and sort field
     *
     * @param dto memberId: is unique id for each member
     *            sortField: if you select location the list is sorting base on nearest location and if you select
     *            validUntil the list is sorting base on validUntil for each coupon descending
     * @return list of CouponMembersItemDto that include couponMembersId, couponId, memberId, validFrom, validUntil
     * and location;
     */
    @Override
    public List<CouponMembersItemDto> getMemberCoupons(GetMemberCouponsDto dto) throws ChangeSetPersister.NotFoundException {

        //memberId validation
        memberValidation(dto.getMemberId());

        //inner method for find member's coupon
        List<CouponMembersItemModel> couponMembersItemModels = findMemberCoupons(dto);

        //declare result value and initialize it (empty list)
        List<CouponMembersItemDto> resultlist = new ArrayList<>();

        //map CouponMembersItemModel to output dto and create list for output
        couponMembersItemModels.forEach
                (couponMembersItemModel -> resultlist.add(memberCouponsMapper.map(couponMembersItemModel)));

        //return result
        return resultlist;
    }

    /**
     * this method is inner method for find member's coupons base on memberId and sort field
     *
     * @param dto memberId: is unique id for each member
     *            sortField: if you select location the list is sorting base on nearest location and if you select
     *            validUntil the list is sorting base on validUntil for each coupon descending
     * @return list of CouponMembersItemModel
     */
    private List<CouponMembersItemModel> findMemberCoupons(GetMemberCouponsDto dto) {

        //determine sort field
        String sortField = (dto.getSortField().equals(GetMemberCouponsDto.SortFields.VALIDUNTIL) ?
                "validUntil" : "coupon.0.location");

        //determine sort order, 1 is ascending and -1 is descending in mongoDB
        int sortOrder = (dto.getSortField().equals(GetMemberCouponsDto.SortFields.LOCATION) ? 1 : -1);

        // call couponMembersRepository mongo repository for getting list of member's coupon
        return couponMembersRepository.findCouponMembers(
                dto.getMemberId(),
                LocalDateTime.now(), // current now for filtering time between validFrom and validUntil
                sortField,
                sortOrder
        );
    }

    /**
     * this methos is checking for memberId that if it is in database
     *
     * @param memberId :each member has a unique id
     * @throws ChangeSetPersister.NotFoundException : not found exception for member id
     */
    private void memberValidation(String memberId) throws ChangeSetPersister.NotFoundException {
        Optional<MemberEntity> memberEntityOptional = memberRepository.findById(memberId);
        if (!memberEntityOptional.isPresent()) {
            throw new ChangeSetPersister.NotFoundException();
        }
    }
}
