package com.business.payback.challengeOne.database.repository;

import com.business.payback.challengeOne.database.entity.CouponEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Nargess
 * this class is a repository for ccess to coupon entity in database
 **/
@Repository
public interface CouponRepository extends MongoRepository<CouponEntity, String> {
}
