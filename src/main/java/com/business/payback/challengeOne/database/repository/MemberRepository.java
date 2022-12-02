package com.business.payback.challengeOne.database.repository;

import com.business.payback.challengeOne.database.entity.MemberEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Nargess
 * this class is a repository for ccess to member entity in database
 **/
@Repository
public interface MemberRepository extends MongoRepository<MemberEntity, String> {
}
