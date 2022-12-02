package com.business.payback.challengeOne.service;

import com.business.payback.challengeOne.api.dto.CouponMembersItemDto;
import com.business.payback.challengeOne.api.dto.GetMemberCouponsDto;
import com.mongodb.BasicDBObjectBuilder;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.query.Query;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author : Nargess
 * Test for MemberCouponService services
 **/

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MemberCouponServiceTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private MemberCouponService memberCouponService;

    /**
     * initColl@Configurationections test method is used for initialize database and entities for testing rest and services
     * order of this test is 1 so it will execute at first when the test is running
     */
    @Order(1)
    @Test
    public void initCollections() {

        //add members to member entity
        createMemberEntity();

        //add coupons to coupon entity
        createCouponEntity();

        //assign coupons to members
        createMemberCouponEntity();
    }

    /**
     * this method is for creating member collection and save data in it
     */
    private void createMemberEntity() {

        //collection name
        String collection = "member";

        //delete all data in collection
        mongoTemplate.findAllAndRemove(new Query(), collection);

        //save data in collection
        mongoTemplate.save(BasicDBObjectBuilder.start()
                .add("_id", new ObjectId("638663b47193803dafba0000")).get(), collection);
        mongoTemplate.save(BasicDBObjectBuilder.start()
                .add("_id", new ObjectId("638663b47193803dafba1111")).get(), collection);
    }

    /**
     * this method is for creating coupon collection and save data in it
     */
    private void createCouponEntity() {

        //collection name
        String collection = "coupon";

        //delete all data in collection
        mongoTemplate.findAllAndRemove(new Query(), collection);

        //save data in collection
        mongoTemplate.save(BasicDBObjectBuilder.start()
                .add("_id", new ObjectId("638663b47193803dafba2222"))
                .add("location", new GeoJsonPoint(12.2, 2.1)).get(), collection);
        mongoTemplate.save(BasicDBObjectBuilder.start()
                .add("_id", new ObjectId("638663b47193803dafba3333"))
                .add("location", new GeoJsonPoint(1.7, 4.71)).get(), collection);
        mongoTemplate.save(BasicDBObjectBuilder.start()
                .add("_id", new ObjectId("638663b47193803dafba4444"))
                .add("location", new GeoJsonPoint(7.0, 6.32)).get(), collection);
        mongoTemplate.save(BasicDBObjectBuilder.start()
                .add("_id", new ObjectId("638663b47193803dafba5555"))
                .add("location", new GeoJsonPoint(4.03, 3.3)).get(), collection);
        mongoTemplate.save(BasicDBObjectBuilder.start()
                .add("_id", new ObjectId("638663b47193803dafba6666"))
                .add("location", new GeoJsonPoint(0.03, 1.01)).get(), collection);
        mongoTemplate.save(BasicDBObjectBuilder.start()
                .add("_id", new ObjectId("638663b47193803dafba7777"))
                .add("location", new GeoJsonPoint(9.03, 5.01)).get(), collection);
        mongoTemplate.save(BasicDBObjectBuilder.start()
                .add("_id", new ObjectId("638663b47193803dafba8888"))
                .add("location", new GeoJsonPoint(13.03, 0.01)).get(), collection);
        mongoTemplate.save(BasicDBObjectBuilder.start()
                .add("_id", new ObjectId("638663b47193803dafba9999"))
                .add("location", new GeoJsonPoint(5.54, 2.91)).get(), collection);
    }

    /**
     * this method is for creating couponMembers collection and save data in it
     */
    private void createMemberCouponEntity() {

        //collection name
        String collection = "couponMembers";

        //delete all data in collection
        mongoTemplate.findAllAndRemove(new Query(), collection);

        //save data in collection
        mongoTemplate.save(BasicDBObjectBuilder.start()
                .add("couponId", "638663b47193803dafba2222")
                .add("memberId", "638663b47193803dafba0000")
                .add("validFrom", LocalDateTime.now().minusHours(1))
                .add("validUntil", LocalDateTime.now().plusHours(1))
                .get(), collection);
        mongoTemplate.save(BasicDBObjectBuilder.start()
                .add("couponId", "638663b47193803dafba3333")
                .add("memberId", "638663b47193803dafba0000")
                .add("validFrom", LocalDateTime.now().minusHours(2))
                .add("validUntil", LocalDateTime.now().plusHours(2))
                .get(), collection);
        mongoTemplate.save(BasicDBObjectBuilder.start()
                .add("couponId", "638663b47193803dafba4444")
                .add("memberId", "638663b47193803dafba0000")
                .add("validFrom", LocalDateTime.now().minusHours(3))
                .add("validUntil", LocalDateTime.now().plusHours(3))
                .get(), collection);
        mongoTemplate.save(BasicDBObjectBuilder.start()
                .add("couponId", "638663b47193803dafba5555")
                .add("memberId", "638663b47193803dafba0000")
                .add("validFrom", LocalDateTime.now().minusHours(4))
                .add("validUntil", LocalDateTime.now().plusHours(4))
                .get(), collection);
        mongoTemplate.save(BasicDBObjectBuilder.start()
                .add("couponId", "638663b47193803dafba6666")
                .add("memberId", "638663b47193803dafba0000")
                .add("validFrom", LocalDateTime.now().minusHours(4))
                .add("validUntil", LocalDateTime.now().minusHours(3))
                .get(), collection);
        mongoTemplate.save(BasicDBObjectBuilder.start()
                .add("couponId", "638663b47193803dafba7777")
                .add("memberId", "638663b47193803dafba0000")
                .add("validFrom", LocalDateTime.now().minusHours(3))
                .add("validUntil", LocalDateTime.now().minusHours(2))
                .get(), collection);
        mongoTemplate.save(BasicDBObjectBuilder.start()
                .add("couponId", "638663b47193803dafba8888")
                .add("memberId", "638663b47193803dafba1111")
                .add("validFrom", LocalDateTime.now().minusHours(3))
                .add("validUntil", LocalDateTime.now().plusHours(2))
                .get(), collection);
        mongoTemplate.save(BasicDBObjectBuilder.start()
                .add("couponId", "638663b47193803dafba9999")
                .add("memberId", "638663b47193803dafba1111")
                .add("validFrom", LocalDateTime.now().minusHours(6))
                .add("validUntil", LocalDateTime.now().minusHours(1))
                .get(), collection);
    }

    /**
     * this test is for some time that memberId isn't valid
     * we except ChangeSetPersister.NotFoundException exception
     */
    @Order(2)
    @Test()
    public void getMemberCouponsInvalidMemberIdTest() {

        //create GetMemberCouponsDto
        GetMemberCouponsDto dto = createGetMemberCouponsDto("000063b47193803dafba0000");

        //call services and assertThrows with NotFoundException
        ChangeSetPersister.NotFoundException exception = assertThrows(
                ChangeSetPersister.NotFoundException.class,
                () -> memberCouponService.getMemberCoupons(dto));
    }

    /**
     * create GetMemberCouponsDto model for input for test getMemberCoupons
     *
     * @return GetMemberCouponsDto
     */
    private GetMemberCouponsDto createGetMemberCouponsDto(String memberId) {

        GetMemberCouponsDto dto = new GetMemberCouponsDto();
        dto.setMemberId(memberId);
        dto.setSortField(GetMemberCouponsDto.SortFields.VALIDUNTIL);

        return dto;
    }

    /**
     * this test is for success situation
     */
    @Order(3)
    @Test()
    public void getMemberCouponsSuccessTest() throws ChangeSetPersister.NotFoundException {

        //create GetMemberCouponsDto
        GetMemberCouponsDto dto = createGetMemberCouponsDto("638663b47193803dafba0000");

        //call services with valid memberId
        List<CouponMembersItemDto> couponMembersItemDtos = memberCouponService.getMemberCoupons(dto);

        //assert result that must not be null
        assertNotNull(couponMembersItemDtos);
    }
}
