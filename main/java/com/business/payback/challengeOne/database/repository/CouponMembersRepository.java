package com.business.payback.challengeOne.database.repository;

import com.business.payback.challengeOne.database.entity.CouponMembersEntity;
import com.business.payback.challengeOne.service.model.CouponMembersItemModel;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author : Nargess
 * this class is a repository for ccess to couponMembers entity in database
 **/

@Repository
public interface CouponMembersRepository extends MongoRepository<CouponMembersEntity, String> {

    /**
     * this method is a aggregate mongo query on 2 collection in database for finding member's coupons and also
     * sort them
     *
     * @param memberId    :get list for one member
     * @param currentDate : for filtering time between validFrom and validUntil
     * @param sortField   : if you select location the list is sorting base on nearest location and if you select
     *                    validUntil the list is sorting base on validUntil for each coupon descending
     * @param sortNumber  : 1 is ascending and -1 is descending in mongoDB
     * @return list of CouponMembersItemModel
     */
    @Aggregation(
            pipeline = {
                    "{'$match' : { 'memberId' : ?0 , 'validFrom': {$lte : ?1} , 'validUntil': {$gte : ?1} }}",
                    "{'$addFields' : {'couponObjId': {'$toObjectId' : '$couponId'}}}",
                    "{'$lookup' : {'from' : 'coupon','localField' : 'couponObjId','foreignField' : '_id','as' : 'coupon'}}",
                    "{'$sort' : {?2 : ?3} }"
            }
    )
    List<CouponMembersItemModel> findCouponMembers
    (String memberId, LocalDateTime currentDate, String sortField, int sortNumber);
}
