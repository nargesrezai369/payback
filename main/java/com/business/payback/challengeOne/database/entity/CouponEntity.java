package com.business.payback.challengeOne.database.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author : Nargess
 * this class is a coupon entity in dtabase for saving coupons
 **/

@Data
@Document("coupon")//document name in database
public class CouponEntity {

    /**
     * each coupon has a unique id
     */
    @Id
    private String id;

    /**
     * each member has location
     */
    private GeoJsonPoint location;
}
