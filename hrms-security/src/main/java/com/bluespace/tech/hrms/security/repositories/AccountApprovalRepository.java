package com.bluespace.tech.hrms.security.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bluespace.tech.hrms.security.domain.AccountApproval;

public interface AccountApprovalRepository extends MongoRepository<AccountApproval, Long> {

	  public abstract AccountApproval findAccountApprovalByUserAccountId(Long paramLong);
	  
	  public abstract AccountApproval findAccountApprovalByIdPendingApproval(Long paramLong);
	  
	  public abstract List<AccountApproval> findAccountApprovalByUserAccountIdAndStatus(long paramLong, String paramString);
	  
	  public abstract List<AccountApproval> findAll();
	  
	  public abstract AccountApproval findAccountApprovalById(long paramLong);
	  
}
