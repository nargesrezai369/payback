package com.business.payback.challengeOne.database.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author : Nargess
 * this class is a coupon entity in dtabase for saving members
 **/

@Data
@Document("member")//document name in database
public class MemberEntity {

    /**
     * each member has a unique id
     */
    @Id
    private String id;
}
