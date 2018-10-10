package com.bluespace.tech.hrms.security.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bluespace.tech.hrms.security.domain.UserAccount;

@Repository
public interface UserAccountRepository extends MongoRepository<UserAccount, Long> {

	public abstract UserAccount findUserAccountByUserName(String paramString);

	public abstract UserAccount findUserAccountByEmail(String paramString);

	/*public abstract UserAccount findUserAccountById(long paramLong);*/

}
