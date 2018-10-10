package com.bluespace.tech.hrms.security.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bluespace.tech.hrms.security.domain.TokenVerification;
import com.bluespace.tech.hrms.security.domain.UserAccount;

@Repository
public interface TokenVerificationRepository extends MongoRepository<TokenVerification, Long> {

	  public abstract TokenVerification findByToken(String paramString);
	  
	  public abstract TokenVerification findTokenByUserAccount(UserAccount paramUserAccount);
	  
	  //public abstract TokenVerification findVerificationTokenByUserId(long paramLong);
	  
}
