package com.business.payback.challengeOne.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author : Nargess
 * this class is input dto for finding list of member's coupon base on memberId
 **/
@Data
public class GetMemberCouponsDto {

    /**
     * each member has a unique id that for getting list of member's coupon , it's required
     */
    @NotNull
    private String memberId;

    /**
     * list should sort base on sortField
     * sortField: if you select location the list is sorting base on nearest location and if you select
     * validUntil the list is sorting base on validUntil for each coupon descending
     */
    @NotNull
    private SortFields sortField;

    /**
     * this is enum class for select SortField by user for sorting list
     */
    public enum SortFields {
        VALIDUNTIL,
        LOCATION
    }

}
