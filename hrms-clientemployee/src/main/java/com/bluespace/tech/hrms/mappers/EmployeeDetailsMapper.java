package com.bluespace.tech.hrms.mappers;

import com.bluespace.tech.hrms.domain.employee.EmployeeDetails;
import com.bluespace.tech.hrms.dto.EmployeeDetailsDTO;

public class EmployeeDetailsMapper {

	public static EmployeeDetails mapDTOToEntity(EmployeeDetailsDTO empDetailsDTO, long id)
	{
		EmployeeDetails empDetails= new EmployeeDetails();
		empDetails.setEmployeeId(id);
		empDetails.setFirstName(empDetailsDTO.getFirstName());
		empDetails.setLastName(empDetailsDTO.getLastName());
		empDetails.setFirstName(empDetailsDTO.getFirstName());
		empDetails.setMiddleName(empDetailsDTO.getMiddleName());
		empDetails.setLegalName(empDetailsDTO.getLegalName());
		empDetails.setEmailId(empDetailsDTO.getEmailId());
		empDetails.setPrimaryEmail(empDetailsDTO.getPrimaryEmail());
		empDetails.setSecondaryEmail(empDetailsDTO.getSecondaryEmail());
		empDetails.setMobileNumber(empDetailsDTO.getMobileNumber());
		empDetails.setHomePhoneNumber(empDetailsDTO.getHomePhoneNumber());
		empDetails.setWorkPhoneNumber(empDetailsDTO.getWorkPhoneNumber());
		empDetails.setSsn(empDetailsDTO.getSsn());
		empDetails.setDateOfBirth(empDetailsDTO.getDateOfBirth());
		empDetails.setGender(empDetailsDTO.getGender());
		empDetails.setProfileImage(empDetailsDTO.getProfileImage());
		empDetails.setPrimaryContact(empDetailsDTO.getPrimaryContact());
		empDetails.setPrimaryContactAltPhone(empDetailsDTO.getPrimaryContactAltPhone());
		empDetails.setPrimaryContactPhone(empDetailsDTO.getPrimaryContactPhone());
		empDetails.setPrimaryContactRelation(empDetailsDTO.getPrimaryContactRelation());
		empDetails.setPrimaryEmail(empDetailsDTO.getPrimaryEmail());
		empDetails.setSecondaryContact(empDetailsDTO.getSecondaryContact());
		empDetails.setSecondaryContactAltPhone(empDetailsDTO.getSecondaryContactAltPhone());
		empDetails.setSecondaryContactPhone(empDetailsDTO.getSecondaryContactPhone());
		empDetails.setSecondaryContactRelation(empDetailsDTO.getSecondaryContactRelation());
		empDetails.setHireDate(empDetailsDTO.getHireDate());
		empDetails.setTerminationDate(empDetailsDTO.getTerminationDate());
		empDetails.setEmploymentLastDate(empDetailsDTO.getEmploymentLastDate());
		empDetails.setClient(empDetailsDTO.getClient());
		empDetails.setCurrentStatus(empDetailsDTO.getCurrentStatus());
		empDetails.setJobTitle(empDetailsDTO.getJobTitle());
		empDetails.setOrganisation(empDetailsDTO.getOrganisation());
		empDetails.setDepartment(empDetailsDTO.getDepartment());
		empDetails.setEmpSalary(empDetailsDTO.getEmpSalary());
		empDetails.setEmploymentStatus(empDetailsDTO.getEmploymentStatus());
		empDetails.setEmploymentType(empDetailsDTO.getEmploymentType());
		empDetails.setReportingManager(empDetailsDTO.getReportingManager());
		empDetails.setActive(empDetailsDTO.isActive());
		empDetails.setCreatedBy(empDetailsDTO.getCreatedBy());
		empDetails.setCreatedOn(empDetailsDTO.getCreatedOn());
		empDetails.setModifiedBy(empDetailsDTO.getModifiedBy());
		empDetails.setModifiedOn(empDetailsDTO.getModifiedOn());
		return empDetails;
	}
}
