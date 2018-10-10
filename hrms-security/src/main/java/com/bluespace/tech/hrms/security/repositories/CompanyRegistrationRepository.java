package com.bluespace.tech.hrms.security.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bluespace.tech.hrms.security.domain.CompanyRegistration;

@Repository
public interface CompanyRegistrationRepository extends MongoRepository<CompanyRegistration, Long> {

	public abstract CompanyRegistration findCompanyRegistrationById(long paramLong);

	public abstract List<CompanyRegistration> findAll();

	public abstract CompanyRegistration findById(CompanyRegistration paramLong);

	public abstract CompanyRegistration findCompanyRegistrationByCompanyNameIgnoreCase(String paramString);

	public abstract List<CompanyRegistration> findCompanyRegistrationByCompanyNameLike(String paramString);
}
