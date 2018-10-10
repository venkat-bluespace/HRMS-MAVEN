package com.bluespace.tech.hrms.security.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.bluespace.tech.hrms.security.core.exception.BusinessException;
import com.bluespace.tech.hrms.security.domain.UserRole;
import com.bluespace.tech.hrms.security.domain.UserRoleAuthority;
import com.bluespace.tech.hrms.security.repositories.UserRoleRepository;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	private UserRoleRepository userRoleRepository;

	@PreAuthorize("hasRole('SUPER_ADMIN') or (hasRole('ACCESS_USER_ROLES'))")
	public UserRole findUserRoleByRoleName(String roleName) {
		return this.userRoleRepository.findUserRoleByRoleName(roleName);
	}

	@PreAuthorize("hasRole('SUPER_ADMIN') or (hasRole('ACCESS_USER_ROLES'))")
	public List<UserRole> findByRoleNameLike(String roleName) {
		return this.userRoleRepository.findByRoleNameLike(roleName);
	}

	@PreAuthorize("hasRole('SUPER_ADMIN') or (hasRole('ACCESS_USER_ROLES'))")
	public List<UserRole> getAllUserRoles() {
		return this.userRoleRepository.findAll();
	}

/*	@PreAuthorize("hasRole('SUPER_ADMIN') or (hasRole('ACCESS_USER_ROLES'))")
	public List<UserRole> findByDescriptionLike(String description) {
		return this.userRoleRepository.findByDescriptionLike(description);
	}

	@PreAuthorize("hasRole('SUPER_ADMIN') or (hasRole('ACCESS_USER_ROLES'))")
	public UserRole getUserRoleById(String userName) {
		return this.userRoleRepository.findOne(userName);
	}

	@PreAuthorize("hasRole('SUPER_ADMIN') or (hasRole('ACCESS_USER_ROLES'))")
	public List<UserRole> getUserRoleByIds(List<Long> userRoleIds) {
		return this.userRoleRepository.findAll(userRoleIds);
	}

	@PreAuthorize("hasRole('SUPER_ADMIN') or (hasRole('CREATE_USER_ROLES'))")
	public UserRole createUserRole(UserRole userRole) throws BusinessException {
		for (UserRoleAuthority userRoleAuthority : userRole.getUserRoleAuthorities()) {
			userRoleAuthority.setUserRole(userRole);
		}
		return (UserRole) this.userRoleRepository.save(userRole);
	}

	@PreAuthorize("hasRole('SUPER_ADMIN') or (hasRole('UPDATE_USER_ROLES'))")
	public UserRole updateUserRole(UserRole userRole) throws BusinessException {
		for (UserRoleAuthority userRoleAuthority : userRole.getUserRoleAuthorities()) {
			userRoleAuthority.setUserRole(userRole);
		}
		return (UserRole) this.userRoleRepository.save(userRole);
	}*/

}
